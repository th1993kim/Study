package kuke.board.articleread.cache;

import lombok.*;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

class OptimizedCacheTest {

    @Test
    void parseDataTest() {
        parseDataTest(1L, 3);
        parseDataTest(1, 3);
        parseDataTest("test", 3);
        parseDataTest(new TestClass("hi"), 3);
    }


    void parseDataTest(Object data, long ttlSeconds) {
        OptimizedCache cache = OptimizedCache.of(data, Duration.ofSeconds(ttlSeconds));
        System.out.println("optimizedCache: " + cache);

        Object result = cache.parseData(data.getClass());

        System.out.println("result : " + result);

        assertThat(result).isEqualTo(data);
    }

    @Getter
    @ToString
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    static class TestClass {
        String value;
    }

    @Test
    void isExpiredTest() {
        assertThat(OptimizedCache.of(1L, Duration.ofSeconds(30)).isExpired()).isFalse();
        assertThat(OptimizedCache.of(1L, Duration.ofSeconds(-30)).isExpired()).isTrue();
    }
}