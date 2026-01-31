package kuke.board.articleread.cache;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static kuke.board.articleread.cache.OptimizedCacheTTL.PHYSICAL_TTL_SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

class OptimizedCacheTTLTest {

    @Test
    void ofTest() {
        long ttlSeconds = 10;

        OptimizedCacheTTL optimizedCacheTTL = OptimizedCacheTTL.of(ttlSeconds);

        assertThat(optimizedCacheTTL.getLogicalTTL()).isEqualTo(Duration.ofSeconds(ttlSeconds));
        assertThat(optimizedCacheTTL.getPhysicalTTL()).isEqualTo(Duration.ofSeconds(ttlSeconds + PHYSICAL_TTL_SECONDS));
    }

}