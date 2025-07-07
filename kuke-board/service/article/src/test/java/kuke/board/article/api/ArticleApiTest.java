package kuke.board.article.api;

import kuke.board.article.service.request.ArticleCreateRequest;
import kuke.board.article.service.request.ArticleUpdateRequest;
import kuke.board.article.service.response.ArticlePageResponse;
import kuke.board.article.service.response.ArticleResponse;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

class ArticleApiTest {
    RestClient restClient = RestClient.create("http://localhost:9000");


    @Test
    void createTest() {
        ArticleResponse articleResponse = create(new ArticleCreateRequest("hi", "mycontent", 1L, 1L));
        System.out.println("Create Response = " + articleResponse);
    }


    ArticleResponse create(ArticleCreateRequest request) {
        return restClient.post()
                .uri("/v1/articles")
                .body(request)
                .retrieve()
                .body(ArticleResponse.class);
    }


    @Test
    void readTest() {
        ArticleResponse read = read(182309301016035328L);
        System.out.println("Read Response = " + read);
    }

    ArticleResponse read(Long articleId) {
        return restClient.get()
                .uri("/v1/articles/{articleId}", articleId)
                .retrieve()
                .body(ArticleResponse.class);
    }

    @Test
    void updateTest() {
        ArticleResponse response = update(182309301016035328L, new ArticleUpdateRequest("new Hi", "new Content"));

        System.out.println("Update Response = " + response);
    }

    ArticleResponse update(Long articleId, ArticleUpdateRequest request) {
        return restClient.put()
                .uri("/v1/articles/{articleId}", articleId)
                .body(request)
                .retrieve()
                .body(ArticleResponse.class);
    }

    @Test
    void deleteTest() {
        restClient.delete()
                .uri("/v1/articles/{articleId}", 182309301016035328L)
                .retrieve()
                .body(Void.class);
    }

    @Test
    void readAllTest() {
        ArticlePageResponse readAll = readAll(1L, 183994L, 30L);
        System.out.println("Read Page Response = " + readAll);
    }

    private ArticlePageResponse readAll(long boardId, long page, long pageSize) {
        return restClient.get()
                .uri("/v1/articles?boardId={boardId}&page={page}&pageSize={pageSize}", boardId, page, pageSize)
                .retrieve()
                .body(ArticlePageResponse.class);
    }

    @Test
    void readAllInfiniteScrollTest() {
        List<ArticleResponse> articles = restClient.get()
                .uri("/v1/articles/infinite-scroll?boardId={boardId}&pageSize={pageSize}", 1L, 10L)
                .retrieve()
                .body(new ParameterizedTypeReference<List<ArticleResponse>>() {});

        for (ArticleResponse article : articles) {
            System.out.println("articleResponse Id : {}" + article.articleId());
        }

        List<ArticleResponse> articles2 = restClient.get()
                .uri("/v1/articles/infinite-scroll?boardId={boardId}&pageSize={pageSize}&lastArticleId={lastArticleId}", 1L, 5L, articles.getLast().articleId())
                .retrieve()
                .body(new ParameterizedTypeReference<List<ArticleResponse>>() {});

        for (ArticleResponse article : articles2) {
            System.out.println("articleResponse Id : {}" + article.articleId());
        }

    }
}
