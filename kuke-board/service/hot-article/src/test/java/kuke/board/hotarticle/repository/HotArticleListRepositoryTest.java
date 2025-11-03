package kuke.board.hotarticle.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HotArticleListRepositoryTest {

    @Autowired
    HotArticleListRepository hotArticleListRepository;

    @Test
    void addTest() throws InterruptedException {
        LocalDateTime time = LocalDateTime.of(2025, 11, 4, 2, 32, 0);
        long limit = 3;


        hotArticleListRepository.add(1L, time, 2L, limit, Duration.ofSeconds(3));
        hotArticleListRepository.add(2L, time, 3L, limit, Duration.ofSeconds(3));
        hotArticleListRepository.add(3L, time, 1L, limit, Duration.ofSeconds(3));
        hotArticleListRepository.add(4L, time, 4L, limit, Duration.ofSeconds(3));
        hotArticleListRepository.add(5L, time, 25L, limit, Duration.ofSeconds(3));

        List<Long> articleIds = hotArticleListRepository.readAll("20251104");

        assertThat(articleIds).hasSize(Math.toIntExact(limit));
        assertThat(articleIds.get(0)).isEqualTo(5L);
        assertThat(articleIds.get(1)).isEqualTo(4L);
        assertThat(articleIds.get(2)).isEqualTo(2L);

        TimeUnit.SECONDS.sleep(5);

        List<Long> secondIds = hotArticleListRepository.readAll("20251104");

        assertThat(secondIds).isEmpty();
    }
}