package kuke.board.like.api;

import kuke.board.like.service.ArticleLikeService;
import kuke.board.like.service.response.ArticleLikeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ArticleLikeController {

    private final ArticleLikeService articleLikeService;

    @GetMapping("/v1/article-likes/articles/{articleId}/users/{userId}")
    public ArticleLikeResponse read(@PathVariable("articleId") Long articleId, @PathVariable("userId") Long userId) {
        return articleLikeService.read(articleId, userId);
    }

    @GetMapping("/v1/article-likes/articles/{articleId}/count")
    public Long read(@PathVariable("articleId") Long articleId) {
        return articleLikeService.count(articleId);
    }

    @PostMapping("/v1/article-likes/articles/{articleId}/users/{userId}/pessimistic-lock")
    public void likePessimisticLock(@PathVariable("articleId") Long articleId, @PathVariable("userId") Long userId) {
        articleLikeService.likePessimisticLock(articleId, userId);
    }

    @DeleteMapping("/v1/article-likes/articles/{articleId}/users/{userId}/pessimistic-lock")
    public void unlikePessimisticLock(@PathVariable("articleId") Long articleId, @PathVariable("userId") Long userId) {
        articleLikeService.unLikePessimisticLock(articleId, userId);
    }

    @PostMapping("/v1/article-likes/articles/{articleId}/users/{userId}/pessimistic-lock/v2")
    public void likePessimisticLockV2(@PathVariable("articleId") Long articleId, @PathVariable("userId") Long userId) {
        articleLikeService.likePessimisticLockV2(articleId, userId);
    }

    @DeleteMapping("/v1/article-likes/articles/{articleId}/users/{userId}/pessimistic-lock/v2")
    public void unlikePessimisticLockV2(@PathVariable("articleId") Long articleId, @PathVariable("userId") Long userId) {
        articleLikeService.unLikePessimisticLockV2(articleId, userId);
    }

    @PostMapping("/v1/article-likes/articles/{articleId}/users/{userId}/optimistic-lock")
    public void likeOptimisticLock(@PathVariable("articleId") Long articleId, @PathVariable("userId") Long userId) {
        articleLikeService.likeOptimisticLock(articleId, userId);
    }

    @DeleteMapping("/v1/article-likes/articles/{articleId}/users/{userId}/optimistic-lock")
    public void unlikeOptimisticLock(@PathVariable("articleId") Long articleId, @PathVariable("userId") Long userId) {
        articleLikeService.unLikeOptimisticLock(articleId, userId);
    }


}
