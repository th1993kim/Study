package kuke.board.article.service.request;

public record ArticleUpdateRequest(
        String title,
        String content
) {
}
