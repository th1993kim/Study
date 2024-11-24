package core.product.infrastructure;

import core.product.entity.ProductEntity;
import core.product.infrastructure.strategy.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class ProductJavaRepositoryTest {

    public static final int THREADS = 10000;
    ProductJavaRepository productRepository;

    @BeforeEach
    void init() {
        productRepository = new ProductJavaRepository();
        productRepository.save(ProductEntity.builder()
                .productName("첫 상품")
                .price(10000)
                .stock(1000)
                .regId(1L)
                .regDateTime(LocalDateTime.now())
                .updateId(1L)
                .updateDateTime(LocalDateTime.now())
                .build());
    }

    @Test
    @DisplayName("Synchronized를 이용해서 재고 수량 동기화")
    void decreaseStockMultiThreadBySynchronized() throws InterruptedException {
        productRepository.setChangeStockWithRock(new MonitorLockChangeStock());
        concurrencyTest();
    }

    private void concurrencyTest() throws InterruptedException {
        int threads = THREADS;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        CountDownLatch countDownLatch = new CountDownLatch(threads);

        for (int i = 0; i < threads; i++) {
            executorService.execute(() -> {
                productRepository.decreaseStock(1L);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();

        ProductEntity productEntity = productRepository.findById(1L)
                .orElse(null);

        assert productEntity != null;
        assertEquals(0, productEntity.getStock());
    }

    @Test
    @DisplayName("ReentrantLock Fair을 이용해서 재고 수량 동기화")
    void decreaseStockMultiThreadByReentrantFairLock() throws InterruptedException {
        productRepository.setChangeStockWithRock(new ReentrantFairLockChangeStock());
        concurrencyTest();
    }

    @Test
    @DisplayName("ReentrantLock NoneFair을 이용해서 재고 수량 동기화")
    void decreaseStockMultiThreadByReentrantNoneFairLock() throws InterruptedException {
        productRepository.setChangeStockWithRock(new ReentrantNoneFairLockChangeStock());
        concurrencyTest();
    }

    @Test
    @DisplayName("ReadWriteLock을 이용해서 재고 수량 동기화")
    void decreaseStockMultiThreadByReentrantReadWriteLock() throws InterruptedException {
        productRepository.setChangeStockWithRock(new ReadWriteLockChangeStock());
        concurrencyTest();
    }

    @Test
    @DisplayName("ReadWriteLock을 이용해서 재고 수량 동기화")
    void decreaseStockMultiThreadBySemaphoreLock() throws InterruptedException {
        productRepository.setChangeStockWithRock(new SemaphoreLockChangeStock());
        concurrencyTest();
    }
}

