package kuke.board.hotarticle.api;

import kuke.board.hotarticle.service.response.HotArticleResponse;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

public class HotArticleApiTest {

    RestClient restClient = RestClient.create("http://localhost:9004");

    @Test
    void readAllTest() {
        List<HotArticleResponse> responseList = restClient.get()
                .uri("/v1/hot-articles/articles/date/20260106")
                .retrieve()
                .body(new ParameterizedTypeReference<List<HotArticleResponse>>() {
                });

        responseList.forEach(response -> {
            System.out.println("response = " + response);
        });
    }
}
