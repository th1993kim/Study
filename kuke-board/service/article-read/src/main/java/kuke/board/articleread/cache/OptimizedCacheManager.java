package kuke.board.articleread.cache;

import kuke.board.common.dataserializer.DataSerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OptimizedCacheManager {

    private final StringRedisTemplate redisTemplate;
    private final OptimizedCacheLockProvider optimizedCacheLockProvider;

    private static final String DELIMITER = "::";

    public Object process(String type, long ttlSeconds, Object[] args, Class<?> returnType, OptimizedCacheOriginDataSupplier<?> originDataSupplier) throws Throwable {

        String key = generateKey(type, args);

        String cachedData = redisTemplate.opsForValue().get(key);

        if (cachedData == null) {
            return refresh(originDataSupplier, key, ttlSeconds);
        }

        OptimizedCache cache = DataSerializer.deserialize(cachedData, OptimizedCache.class);
        if (cache == null) {
            return refresh(originDataSupplier, key, ttlSeconds);
        }

        if (!cache.isExpired()) {
            return cache.parseData(returnType);
        }

        if (!optimizedCacheLockProvider.lock(key)) {
            return cache.parseData(returnType);
        }

        try {
            return refresh(originDataSupplier, key, ttlSeconds);
        } finally {
            optimizedCacheLockProvider.unlock(key);
        }
    }

    private Object refresh(OptimizedCacheOriginDataSupplier<?> originDataSupplier, String key, long ttlSeconds) throws Throwable {
        Object result = originDataSupplier.get();

        OptimizedCacheTTL optimizedCacheTTL = OptimizedCacheTTL.of(ttlSeconds);
        OptimizedCache cache = OptimizedCache.of(result, optimizedCacheTTL.getLogicalTTL());

        redisTemplate.opsForValue()
                .set(key, DataSerializer.serialize(cache), optimizedCacheTTL.getPhysicalTTL());

        return result;
    }

    private String generateKey(String prefix, Object[] args) {
        return prefix + DELIMITER +
                Arrays.stream(args)
                        .map(String::valueOf)
                        .collect(Collectors.joining(DELIMITER));
    }

}
