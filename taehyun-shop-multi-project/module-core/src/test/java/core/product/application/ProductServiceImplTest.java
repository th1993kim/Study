package core.product.application;

import core.product.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Sql(scripts = {"classpath:sql/product.sql"})
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;


    @Test
    @Transactional
    void updateProductPessimisticReadLock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CountDownLatch countDownLatch = new CountDownLatch(2);

        for (int i = 0; i < 2; i++) {
            executorService.execute(() -> {
                countDownLatch.countDown();
                productService.updateProductPessimisticReadLock(1L);
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isEqualTo(18);
    }

    @Test
    void updateProductPessimisticWriteLock() {
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