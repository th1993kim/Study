package kuke.board.like.api;

import kuke.board.like.service.response.ArticleLikeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ArticleLikeApiTest {

    RestClient restClient = RestClient.create("http://localhost:9002");


    @Test
    void likeAndUnlikeTest() {
        Long articleId = 9999L;

        long user1 = 1L;
        long user2 = 2L;
        long user3 = 3L;
        final String lockPath = "/pessimitic-lock";
        like(articleId, user1, lockPath);
        like(articleId, user2, lockPath);
        like(articleId, user3, lockPath);

        ArticleLikeResponse like1 = read(articleId, user1);
        ArticleLikeResponse like2 = read(articleId, user2);
        ArticleLikeResponse like3 = read(articleId, user3);

        System.out.println("like1: " + like1);
        System.out.println("like2: " + like2);
        System.out.println("like3: " + like3);
        unLike(articleId, user1, lockPath);
        unLike(articleId, user2, lockPath);
        unLike(articleId, user3, lockPath);
    }


    void like(Long articleId, Long userId, String lockPath) {
        restClient.post()
                .uri("/v1/article-likes/articles/{articleId}/users/{userId}" + lockPath, articleId, userId)
                .retrieve()
                .body(Void.class);
    }

    void unLike(Long articleId, Long userId, String lockPath) {
        restClient.delete()
                .uri("/v1/article-likes/articles/{articleId}/users/{userId}" + lockPath, articleId, userId)
                .retrieve()
                .body(Void.class);
    }

    ArticleLikeResponse read(Long articleId, Long userId) {
        return restClient.get()
                .uri("/v1/article-likes/articles/{articleId}/users/{userId}", articleId, userId)
                .retrieve()
                .body(ArticleLikeResponse.class);
    }


    @Test
    void likePerformanceTest() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        likePerformanceTest(executorService, 111L, "/pessimistic-lock");
        likePerformanceTest(executorService, 222L, "/pessimistic-lock/v2");
        likePerformanceTest(executorService, 333L, "/optimistic-lock");
    }

    void likePerformanceTest(ExecutorService executorService, Long articleId, String lockType) throws InterruptedException {

        int totalRepeatCount = 3000;
        CountDownLatch countDownLatch = new CountDownLatch(totalRepeatCount);
        System.out.println(lockType + " start");

        long start = System.nanoTime();
        for (int i = 0; i < totalRepeatCount; i++) {
            long userId = i + 2;
            executorService.submit(() -> {
                try {
                    like(articleId, userId, lockType);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();

        long end = System.nanoTime();

        System.out.println("lock Type" + lockType + ", time = " + (end - start) / 1000000 + "ms");
        System.out.println(lockType + " end");

        Long count = restClient.get()
                .uri("/v1/article-likes/articles/{articleId}/count", articleId)
                .retrieve()
                .body(Long.class);

        System.out.println(count + " count");
    }
}