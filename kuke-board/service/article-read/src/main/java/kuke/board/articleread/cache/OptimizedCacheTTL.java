package kuke.board.articleread.cache;

import lombok.Getter;

import java.time.Duration;

@Getter
public class OptimizedCacheTTL {

    private Duration logicalTTL;
    private Duration physicalTTL;

    public static final long PHYSICAL_TTL_SECONDS = 5L;

    public static OptimizedCacheTTL of(long ttlSeconds) {
        OptimizedCacheTTL ttl = new OptimizedCacheTTL();
        ttl.logicalTTL = Duration.ofSeconds(ttlSeconds);
        ttl.physicalTTL = ttl.logicalTTL.plusSeconds(PHYSICAL_TTL_SECONDS);
        return ttl;
    }
}
