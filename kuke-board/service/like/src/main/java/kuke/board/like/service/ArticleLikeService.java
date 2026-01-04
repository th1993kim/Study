package kuke.board.like.service;

import kuke.board.common.event.EventType;
import kuke.board.common.event.payload.ArticleLikedEventPayload;
import kuke.board.common.event.payload.ArticleUnlikedEventPayload;
import kuke.board.common.snowflake.Snowflake;
import kuke.board.like.entity.ArticleLike;
import kuke.board.like.entity.ArticleLikeCount;
import kuke.board.like.repository.ArticleLikeCountRepository;
import kuke.board.like.repository.ArticleLikeRepository;
import kuke.board.like.service.response.ArticleLikeResponse;
import kuke.board.outboxmessagerelay.OutboxEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleLikeService {
    private final Snowflake snowflake = new Snowflake();
    private final ArticleLikeRepository articleLikeRepository;
    private final ArticleLikeCountRepository articleLikeCountRepository;
    private final OutboxEventPublisher outboxEventPublisher;


    @Transactional(readOnly = true)
    public ArticleLikeResponse read(Long articleId, Long userId) {
        return articleLikeRepository.findByArticleIdAndUserId(articleId, userId)
                .map(ArticleLikeResponse::from)
                .orElseThrow();
    }

    @Transactional
    public void likePessimisticLock(Long articleId, Long userId) {
        ArticleLike articleLike = ArticleLike.create(
                snowflake.nextId(),
                articleId,
                userId
        );
        articleLikeRepository.save(articleLike);
        int result = articleLikeCountRepository.increase(articleId);

        //최초 요청시에는 update 되는 레코드가 없으므로 1로 초기화
        // 트래픽이 몰릴 수 있는 상황에는 게시글 생성 시점에 미리 0으로 초기화 해둘 수 있음.
        if (result == 0) {
            articleLikeCountRepository.save(
                    ArticleLikeCount.init(articleId, 1L)
            );
        }

        outboxEventPublisher.publish(
                EventType.ARTICLE_LIKED,
                ArticleLikedEventPayload.builder()
                        .articleLikeId(articleLike.getArticleLikeId())
                        .articleId(articleLike.getArticleId())
                        .userId(articleLike.getUserId())
                        .createAt(articleLike.getCreatedAt())
                        .articleLikeCount(count(articleLike.getArticleId()))
                        .build(),
                articleLike.getArticleId()
        );
    }

    @Transactional
    public void unLikePessimisticLock(Long articleId, Long userId) {
        articleLikeRepository.findByArticleIdAndUserId(articleId, userId)
                .ifPresent(entity -> {
                    articleLikeRepository.delete(entity);
                    articleLikeCountRepository.decrease(articleId);

                    outboxEventPublisher.publish(
                            EventType.ARTICLE_UNLIKED,
                            ArticleUnlikedEventPayload.builder()
                                    .articleLikeId(entity.getArticleLikeId())
                                    .articleId(entity.getArticleId())
                                    .userId(entity.getUserId())
                                    .createAt(entity.getCreatedAt())
                                    .articleLikeCount(count(entity.getArticleId()))
                                    .build(),
                            entity.getArticleId()
                    );
                });
    }


    @Transactional
    public void likePessimisticLockV2(Long articleId, Long userId) {
        articleLikeRepository.save(ArticleLike.create(
                snowflake.nextId(),
                articleId,
                userId
        ));

        ArticleLikeCount articleLikeCount = articleLikeCountRepository.findLockedByArticleId(articleId)
                .orElseGet(() -> ArticleLikeCount.init(articleId, 1L));
        articleLikeCount.increase();
        articleLikeCountRepository.save(articleLikeCount);
    }

    @Transactional
    public void unLikePessimisticLockV2(Long articleId, Long userId) {
        articleLikeRepository.findByArticleIdAndUserId(articleId, userId)
                .ifPresent(entity -> {
                    articleLikeRepository.delete(entity);
                    articleLikeCountRepository.decrease(articleId);
                });
    }

    @Transactional
    public void likeOptimisticLock(Long articleId, Long userId) {
        articleLikeRepository.save(ArticleLike.create(
                snowflake.nextId(),
                articleId,
                userId
        ));

        ArticleLikeCount articleLikeCount = articleLikeCountRepository.findById(articleId)
                .orElseGet(() -> ArticleLikeCount.init(articleId, 1L));

        articleLikeCount.increase();
        articleLikeCountRepository.save(articleLikeCount);
    }

    @Transactional
    public void unLikeOptimisticLock(Long articleId, Long userId) {
        articleLikeRepository.findById(articleId)
                .ifPresent(articleLike -> {
                    articleLikeRepository.delete(articleLike);
                    ArticleLikeCount articleLikeCount = articleLikeCountRepository.findById(articleId).orElseThrow();
                    articleLikeCount.decrease();
                });
    }


    @Transactional(readOnly = true)
    public Long count(Long articleId) {
        return articleLikeCountRepository.findById(articleId)
                .map(ArticleLikeCount::getLikeCount)
                .orElse(0L);
    }
}
