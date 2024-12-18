package core.product.application;

import core.product.entity.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
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
                log.debug("Update Start CurrentThread = {}", Thread.currentThread());
                productService.updateProductPessimisticReadLock(1L);
                log.debug("Update End CurrentThread = {}", Thread.currentThread());
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
                log.debug("Update Start CurrentThread = {}", Thread.currentThread());
                productService.updateProductPessimisticWriteLock(1L);
                log.debug("Update End CurrentThread = {}", Thread.currentThread());
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isEqualTo(0);
    }

    @Test
    void updateProductPessimisticForceIncrementLock() {
    }

    @Test
    void updateProductOptimisticLock() {
    }

    @Test
    void updateProductOptimisticForceIncrementLock() {
    }
}