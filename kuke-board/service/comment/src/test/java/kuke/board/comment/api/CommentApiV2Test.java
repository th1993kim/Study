package kuke.board.comment.api;

import kuke.board.comment.service.response.CommentPageResponse;
import kuke.board.comment.service.response.CommentResponse;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

public class CommentApiV2Test {

    RestClient restClient = RestClient.create("http://localhost:9001");


//    response1.get Comment ID :207574444018524160 path:00002
//    response2.get Comment ID :207574444303736832 path:0000200000
//    response3.get Comment ID :207574444370845696 path:000020000000000
    @Test
    void create() {
        CommentResponse response1 = createComment(new CommentCreateRequestV2(1L, "comment1", null, 1L));
        CommentResponse response2 = createComment(new CommentCreateRequestV2(1L, "comment2", response1.path(), 1L));
        CommentResponse response3 = createComment(new CommentCreateRequestV2(1L, "comment3", response2.path(), 1L));

        System.out.println("response1.get Comment ID :" + response1.commentId() + " path:" + response1.path());
        System.out.println("response2.get Comment ID :" + response2.commentId()  + " path:" + response2.path());
        System.out.println("response3.get Comment ID :" + response3.commentId()  + " path:" + response3.path());
    }

    private CommentResponse createComment(CommentCreateRequestV2 request) {
        return restClient.post()
                .uri("/v2/comments")
                .body(request)
                .retrieve()
                .body(CommentResponse.class);
    }


    private record CommentCreateRequestV2(
            Long articleId,
            String content,
            String parentPath,
            Long writerId
    ) {

    }

    @Test
    void read() {
        CommentResponse response = restClient.get()
                .uri("/v2/comments/{commentId}", 207574444018524160L)
                .retrieve()
                .body(CommentResponse.class);

        System.out.println("response: " + response.path());
    }

    @Test
    void delete() {
        restClient.delete()
                .uri("/v2/comments/{commentId}", 207574444018524160L)
                .retrieve()
                .body(Void.class);
    }


    @Test
    void readAll() {
        CommentPageResponse response = restClient.get()
                .uri("/v2/comments?articleId=1&page=1&pageSize=10")
                .retrieve()
                .body(CommentPageResponse.class);


        System.out.println("response: " + response);
    }

    @Test
    void readAllInfiniteScroll() {
        List<CommentResponse> response = restClient.get()
                .uri("/v2/comments/infinite?articleId=1&pageSize=10")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});


        System.out.println("response: " + response);
        String lastPath = response.getLast()
                .path();
        List<CommentResponse> secondPage = restClient.get()
                .uri("/v2/comments/infinite?articleId=1&lastPath=" + lastPath + "&pageSize=10")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});


        System.out.println("secondPage: " + secondPage);
    }

    @Test
    void countTest() {
        CommentResponse response = createComment(new CommentCreateRequestV2(2L, "comment1", null, 1L));

        Long count = restClient.get()
                .uri("/v2/comments/articles/{articleId}/count", 2L)
                .retrieve()
                .body(Long.class);

        System.out.println("count: " + count);

        restClient.delete()
                .uri("/v2/comments/{commentId}", response.commentId())
                .retrieve()
                .body(Void.class);


        Long count2 = restClient.get()
                .uri("/v2/comments/articles/{articleId}/count", 2L)
                .retrieve()
                .body(Long.class);

        System.out.println("count2: " + count2);

    }

}

