package kuke.board.articleread.api;

import kuke.board.articleread.service.response.ArticleReadPageResponse;
import kuke.board.articleread.service.response.ArticleReadResponse;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

public class ArticleReadApiTest {
    RestClient articleReadRestClient = RestClient.create("http://localhost:9005");
    RestClient articleRestClient = RestClient.create("http://localhost:9000");

    @Test
    void readTest() {
        ArticleReadResponse response = articleReadRestClient.get()
                .uri("/v1/articles/{articleId}", 200080117472940040L)
                .retrieve()
                .body(ArticleReadResponse.class);

        System.out.println("response = " + response);


    }

    @Test
    void readAllTest() {
        ArticleReadPageResponse response = articleReadRestClient.get()
                .uri("/v1/articles?boardId={boardId}&page={page}&pageSize={pageSize}", 1L, 1L, 5L)
                .retrieve()
                .body(ArticleReadPageResponse.class);

        System.out.println("article Count = " + response.getArticleCount());
        response.getArticles()
                .forEach(article -> System.out.println("articleId = " + article.getArticleId()));

        ArticleReadPageResponse response2 = articleRestClient.get()
                .uri("/v1/articles?boardId={boardId}&page={page}&pageSize={pageSize}", 1L, 1L, 5L)
                .retrieve()
                .body(ArticleReadPageResponse.class);

        System.out.println("article Count = " + response2.getArticleCount());
        response2.getArticles()
                .forEach(article -> System.out.println("articleId = " + article.getArticleId()));
    }

    @Test
    void readAllInfiniteScrollTest() {
        List<ArticleReadResponse> responseList = articleReadRestClient.get()
                .uri("/v1/articles/infinite-scroll?boardId={boardId}&lastArticleId={lastArticleId}&pageSize={pageSize}", 1L, 274940166980018176L, 5L)
                .retrieve()
                .body(new ParameterizedTypeReference<List<ArticleReadResponse>>() {});

        System.out.println("article Count = " + responseList.size());
        responseList.forEach(article -> System.out.println("articleId = " + article.getArticleId()));

        List<ArticleReadResponse> responseList2 = articleRestClient.get()
                .uri("/v1/articles/infinite-scroll?boardId={boardId}&lastArticleId={lastArticleId}&pageSize={pageSize}", 1L, 274940166980018176L, 5L)
                .retrieve()
                .body(new ParameterizedTypeReference<List<ArticleReadResponse>>() {});

        System.out.println("article Count = " + responseList2.size());
        responseList2.forEach(article -> System.out.println("articleId = " + article.getArticleId()));
    }
}
