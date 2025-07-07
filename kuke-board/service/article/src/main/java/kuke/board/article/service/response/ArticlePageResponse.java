package kuke.board.article.service.response;

import java.util.List;

public record ArticlePageResponse(
        List<ArticleResponse> articles,
        Long articleCount
) {

}
