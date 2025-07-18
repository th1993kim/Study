package kuke.board.comment.service.response;

import kuke.board.comment.entity.Comment;

import java.time.LocalDateTime;

public record CommentResponse(
        Long commentId,
        String content,
        Long parentCommentId,
        Long articleId,
        Long writerId,
        Boolean deleted,
        LocalDateTime createdAt
) {

    public static CommentResponse from(Comment comment) {
        return new CommentResponse(
                comment.getCommentId(),
                comment.getContent(),
                comment.getParentCommentId(),
                comment.getArticleId(),
                comment.getWriterId(),
                comment.getDeleted(),
                comment.getCreatedAt()
        );
    }
}
