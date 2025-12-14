package kuke.board.hotarticle.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Repository
@RequiredArgsConstructor
public class ArticleCreatedTimeRepository {

    private final StringRedisTemplate redisTemplate;

    private static final String KEY_FORMAT = "hot-article::article::%s::create-time";

    public void createOrUpdate(Long articleId, LocalDateTime createdAt, Duration ttl) {
        redisTemplate.opsForValue().set(generateKey(articleId), String.valueOf(createdAt.toInstant(ZoneOffset.UTC).toEpochMilli()), ttl);
    }

    public void delete(Long articleId) {
        redisTemplate.delete(generateKey(articleId));
    }

    public LocalDateTime read(Long articleId) {
        String result = redisTemplate.opsForValue().get(generateKey(articleId));

        return result != null ? LocalDateTime.ofInstant(
                Instant.ofEpochMilli(Long.parseLong(result)), ZoneOffset.UTC
        ) : null;
    }

    public String generateKey(Long articleId) {
        return String.format(KEY_FORMAT, articleId);
    }
}
