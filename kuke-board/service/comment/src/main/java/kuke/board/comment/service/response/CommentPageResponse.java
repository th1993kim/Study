package kuke.board.comment.service.response;

import java.util.List;

public record CommentPageResponse(
        List<CommentResponse> comments,
        Long commentCount
) {

    public static CommentPageResponse of(List<CommentResponse> list, Long count) {
        return new CommentPageResponse(list, count);
    }
}
