package kuke.board.comment.service;

import kuke.board.comment.entity.Comment;
import kuke.board.comment.repository.CommentRepository;
import kuke.board.comment.service.request.CommentCreateRequest;
import kuke.board.comment.service.response.CommentPageResponse;
import kuke.board.comment.service.response.CommentResponse;
import kuke.board.common.snowflake.Snowflake;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.function.Predicate.not;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final Snowflake snowflake = new Snowflake();


    @Transactional
    public CommentResponse create(CommentCreateRequest request) {

        Comment parent = findParent(request);

        Comment comment = commentRepository.save(Comment.create(
                snowflake.nextId(),
                request.content(),
                parent == null ? null : parent.getCommentId(),
                request.articleId(),
                request.writerId()
        ));

        return CommentResponse.from(comment);
    }

    private Comment findParent(CommentCreateRequest request) {

        Long parentCommentId = request.parentCommentId();

        if (parentCommentId != null) {
            return commentRepository.findById(parentCommentId)
                    .filter(not(Comment::getDeleted))
                    .filter(Comment::isRoot)
                    .orElseThrow();
        }

        return null;
    }


    @Transactional(readOnly = true)
    public CommentResponse read(Long commentId) {
        return CommentResponse.from(commentRepository.findById(commentId)
                .orElseThrow());
    }

    @Transactional
    public void delete(Long commentId) {
        commentRepository.findById(commentId)
                .filter(not(Comment::getDeleted))
                .ifPresent(comment -> {
                    if (hasChildren(comment)) {
                        comment.delete();
                    } else {
                        delete(comment);
                    }
                });
        ;
    }

    private boolean hasChildren(Comment comment) {
        return commentRepository.countBy(comment.getArticleId(), comment.getCommentId(), 2L) == 2L;
    }

    private void delete(Comment comment) {
        commentRepository.delete(comment);
        if (!comment.isRoot()) {
            commentRepository.findById(comment.getParentCommentId())
                    .filter(Comment::getDeleted)
                    .filter(not(this::hasChildren))
                    .ifPresent(this::delete);
        }
    }

    @Transactional(readOnly = true)
    public CommentPageResponse readAll(Long articleId, Long page, Long pageSize) {

        return new CommentPageResponse(
                commentRepository.findAll(articleId, (page - 1) * pageSize, pageSize)
                        .stream()
                        .map(CommentResponse::from)
                        .toList(),
                commentRepository.count(articleId, PageLimitCalculator.calculatePageLimit(page, pageSize, 10L))
        );
    }


    public List<CommentResponse> readAll(Long articleId, Long lastParentCommentId, Long lastCommentId, Long limit) {
        List<Comment> comments = lastParentCommentId == null || lastCommentId == null ?
                commentRepository.findAllInfInfiniteScroll(articleId, limit) :
                commentRepository.findAllInfInfiniteScroll(articleId, lastParentCommentId, lastCommentId, limit);
        return comments.stream()
                .map(CommentResponse::from)
                .toList();
    }
}
