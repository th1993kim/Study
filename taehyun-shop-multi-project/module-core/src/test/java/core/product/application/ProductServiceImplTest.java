package core.product.application;

import core.product.entity.ProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;


@ActiveProfiles("core-test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Sql(scripts = {"classpath:sql/product.sql"})
@Slf4j
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;


    @Test
    @Rollback
    void updateProductPessimisticReadLock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                productService.updateProductPessimisticReadLock(1L);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isEqualTo(0);
    }

    @Test
    void updateProductPessimisticWriteLock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                productService.updateProductPessimisticWriteLock(1L);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isEqualTo(0);
    }

    @Test
    void updateProductPessimisticForceIncrementLock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                productService.updateProductPessimisticForceIncrementLock(1L);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isEqualTo(0);
    }

    @Test
    void updateProductOptimisticLock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                productService.updateProductOptimisticLock(1L);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isEqualTo(0);
    }

    @Test
    void updateProductOptimisticForceIncrementLock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                productService.updateProductOptimisticForceIncrementLock(1L);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isEqualTo(0);
    }
    @Test
    void updateProductReadLock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                productService.updateProductReadLock(1L);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isEqualTo(0);
    }
    @Test
    void updateProductWriteLock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                productService.updateProductWriteLock(1L);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isEqualTo(0);
    }

    @Test
    @DisplayName("락이 존재하지 않는 경우 20개의 스레드가 1개씩 줄여나간다고 해서 0개가 되지 않는다.")
    void updateProductNoneLock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                productService.updateProductNoneLock(1L);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isNotEqualTo(0);
    }

    @Test
    @DisplayName("락이 존재하지 않는 경우 20개의 스레드가 1개씩 줄여나간다고 해서 0개가 되지 않는다.")
    void updateProductSharedLock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                productService.updateProductSharedLock(1L);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isEqualTo(0);
    }

    @Test
    @DisplayName("락이 존재하지 않는 경우 20개의 스레드가 1개씩 줄여나간다고 해서 0개가 되지 않는다.")
    void updateProductExclusiveLock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                productService.updateProductExclusiveLock(1L);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isEqualTo(0);
    }
}