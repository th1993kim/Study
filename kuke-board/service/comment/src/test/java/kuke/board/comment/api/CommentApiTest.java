package kuke.board.comment.api;

import kuke.board.comment.service.response.CommentPageResponse;
import kuke.board.comment.service.response.CommentResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.lang.reflect.Type;
import java.util.List;

@Slf4j
public class CommentApiTest {

    RestClient restClient = RestClient.create("http://localhost:9001");


    @Test
    void create() {
        CommentResponse content = createComment(new CommentCreateRequest(1L, "content", null, 1L));
        CommentResponse content1 = createComment(new CommentCreateRequest(1L, "content1", content.commentId(), 1L));
        CommentResponse content2 = createComment(new CommentCreateRequest(1L, "content2", content.commentId(), 1L));

        log.info("content: commentID: {}", content.commentId());
        log.info("content1: commentID: {}", content1.commentId());
        log.info("content2: commentID: {}", content2.commentId());
//        08:59:34.651 [Test worker] INFO kuke.board.comment.api.CommentApiTest -- content: commentID: 201125158300741632
//        08:59:34.654 [Test worker] INFO kuke.board.comment.api.CommentApiTest -- content1: commentID: 201125158963441664
//        08:59:34.654 [Test worker] INFO kuke.board.comment.api.CommentApiTest -- content2: commentID: 201125159038939136
    }

    private CommentResponse createComment(CommentCreateRequest request) {
        return restClient.post()
                .uri("/v1/comments")
                .body(request)
                .retrieve()
                .body(CommentResponse.class);
    }


    @Getter
    @AllArgsConstructor
    public static class CommentCreateRequest {
        private Long articleId;
        private String content;
        private Long parentCommentId;
        private Long writerId;
    }


    @Test
    void read() {
        CommentResponse response = restClient.get()
                .uri("/v1/comments/{commentId}", 201125158300741632L)
                .retrieve()
                .body(CommentResponse.class);
        log.info("comment: {}", response);
    }

    @Test
    void delete() {
        restClient.delete()
                .uri("/v1/comments/{commentId}", 201125158963441664L)
                .retrieve()
                .body(Void.class);
    }


    @Test
    void readAll() {
        CommentPageResponse response = restClient.get()
                .uri("/v1/comments?articleId={articleId}&page={page}&pageSize={pageSize}", 1L, 1L, 10L)
                .retrieve()
                .body(CommentPageResponse.class);

        response.comments()
                        .forEach(comment -> log.info("comment: {}", comment));
    }

    @Test
    void readAllInfiniteScroll() {
        List<CommentResponse> firstPage = restClient.get()
                .uri("/v1/comments/infinite-scroll?articleId={articleId}&pageSize={pageSize}", 1L, 10L)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });

        firstPage.forEach(comment -> log.info("firstPage comment: {}", comment));

        Long lastParentCommentId = firstPage.getLast().parentCommentId();
        Long lastCommentId = firstPage.getLast().commentId();


        List<CommentResponse> secondPage = restClient.get()
                .uri("/v1/comments/infinite-scroll?articleId={articleId}&pageSize={pageSize}&lastParentCommentId={lastParentCommentId}&lastCommentId={lastCommentId}", 1L, 10L, lastParentCommentId, lastCommentId)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });

        secondPage.forEach(comment -> log.info("secondPage comment: {}", comment));
    }
}
