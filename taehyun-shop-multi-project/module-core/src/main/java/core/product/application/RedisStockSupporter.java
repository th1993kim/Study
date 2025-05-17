package core.product.application;

import lombok.RequiredArgsConstructor;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class RedisStockSupporter implements StockSupporter {

    private final RedissonClient redissonClient;

    @Override
    public boolean acquireLock(long seqProduct) {
        try {
            return redissonClient.getLock("product:" + seqProduct + ":stock")
                    .tryLock(2L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            return false;
        }
    }

    @Override
    public void releaseLock(long seqProduct) {
        redissonClient.getLock("product:" + seqProduct + ":stock")
                .unlock();
    }

    @Override
    public long addStock(long seqProduct, int addCount) {
        try {
            RAtomicLong atomicLong = redissonClient.getAtomicLong("");
            return atomicLong.addAndGet(addCount);
        } catch (Exception e) {
            throw new RuntimeException("재고 감소 처리에 실패하였습니다.");
        }
    }
}
