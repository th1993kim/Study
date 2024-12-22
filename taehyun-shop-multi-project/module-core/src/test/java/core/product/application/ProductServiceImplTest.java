package core.product.application;

import core.product.entity.ProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;


@ActiveProfiles("core-test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Sql(scripts = {"classpath:sql/product.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = {"classpath:sql/product-clear.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@Slf4j
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;


    @Test
    @Rollback
    @DisplayName("동시적으로 재고를 수정하기 위해 비관적 읽기 락을 사용하는 경우 트랜잭션의 일부가 락을 획득하지 못하여 재고가 0으로 맞춰지지 않는다.")
    void updateProductPessimisticReadLock() throws InterruptedException {
        final int threads = 200;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            executorService.execute(() -> {
                try {
                    productService.updateProductPessimisticReadLock(1L);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isNotEqualTo(0);
    }

    @Test
    @Rollback
    @DisplayName("동시적으로 재고를 수정하기 위해 비관적 읽기 락 + 스핀락을 사용하는 경우 재고를 0으로 맞출 수 있다.")
    void updateProductPessimisticReadLock_IsZero_WithSpinLock() throws InterruptedException {
        final int threads = 200;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            executorService.execute(() -> {
                while (true) {
                    try {
                        productService.updateProductPessimisticReadLock(1L);
                        break;
                    } catch (CannotAcquireLockException e) {
                        log.error(e.getMessage(), e);
                    }
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isEqualTo(0);
    }

    @Test
    @DisplayName("대기가 있는 비관적 쓰기 락을 사용하면, 먼저 락을 획득한 트랜잭션으로부터 차례대로 처리되기 때문에 재고가0으로 수렴한다.")
    void updateProductPessimisticWriteLock() throws InterruptedException {
        final int threads = 200;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
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
    @DisplayName("대기가 없는 비관적락을 사용하는 경우, 락을 획득하지 못하는 경우 예외가 발생하기때문에, 재고가 0으로 수렴하지 못한다.")
    void updateProductPessimisticForceIncrementLock() throws InterruptedException {
        int threads = 200;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            executorService.execute(() -> {
                try {
                    productService.updateProductPessimisticForceIncrementLock(1L);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isNotEqualTo(0);
    }

    @Test
    @DisplayName("대기가 없는 비관적락의 경우, 스핀락을 통해서 재고를 0으로 수렴할 수 있게 한다.")
    void updateProductPessimisticForceIncrementLock_IsZero_SpinTest() throws InterruptedException {
        int threads = 200;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            executorService.execute(() -> {
                while(true) {
                    try {
                        productService.updateProductPessimisticForceIncrementLock(1L);
                        break;
                    } catch (PessimisticLockingFailureException e) {

                    }
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isEqualTo(0);
    }

    @Test
    @DisplayName("낙관적 락을 이용하는 경우, 스핀락을 이용하여 처리하면 재고를 0으로 만들 수 있고, 버전은 해당 횟수만큼 변경된다.")
    void updateProductOptimisticLock_IsZero_WithSpinLockTest() throws InterruptedException {
        int threads = 200;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            executorService.execute(() -> {
                while (true) {
                    try {
                        productService.updateProductOptimisticLock(1L);
                        break;
                    } catch (OptimisticLockingFailureException e) {
                        log.error(e.getMessage(), e);
                    }
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getVersion()).isEqualTo(200L);
        assertThat(product.getStock()).isEqualTo(0);
    }
    @Test
    @DisplayName("낙관적 락을 이용하는 경우, 동시에 같은 버전 정보를 획득하여 처리하기 때문에 재고를 0으로 만들지 못한다.")
    void updateProductOptimisticLock() throws InterruptedException {
        int threads = 200;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            executorService.execute(() -> {
                try {
                    productService.updateProductOptimisticLock(1L);
                } catch (PessimisticLockingFailureException e) {
                    log.error(e.getMessage(), e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isNotEqualTo(0);
    }

    @Test
    @DisplayName("동시적으로 낙관적락 + 강제 버전업데이트를 이용하면 버전정보가 맞지 않아 수량이 정확히 변경되지 않는다.")
    void updateProductOptimisticForceIncrementLock_IsNotZeroTest() throws InterruptedException {
        int threads = 200;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            executorService.execute(() -> {
                try {
                    productService.updateProductOptimisticForceIncrementLock(1L);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isNotEqualTo(20L);
    }

    @Test
    @DisplayName("낙관적락 + 강제 버전업데이트과 스핀락을 200번 요청하면 버전필드가 400으로 지정된다.")
    void updateProductOptimisticForceIncrementLock_IsZeroTest() throws InterruptedException {
        final int threads = 200;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            executorService.execute(() -> {
                while (true) {
                    try {
                        productService.updateProductOptimisticForceIncrementLock(1L);
                        break;
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getVersion()).isEqualTo(400L);
        assertThat(product.getStock()).isEqualTo(0L);
    }

    @Test
    @DisplayName("OptimisticLock과 동일하게 버전필드를 이용해서 처리되어, 재고가 0으로 되지 않는다.")
    void updateProductReadLock() throws InterruptedException {
        int threads = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            executorService.execute(() -> {
                try {
                    productService.updateProductReadLock(1L);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isNotEqualTo(0);
    }

    @Test
    @DisplayName("OptimisticLock과 동일하게 버전필드를 이용해서 처리되어, 재고가 0으로 되지 않는다.")
    void updateProductWriteLock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                try {
                    productService.updateProductWriteLock(1L);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isNotEqualTo(0);
    }

    @Test
    @DisplayName("락이 존재하지 않는 경우 20개의 스레드가 1개씩 줄여나간다고 해서 0개가 되지 않는다.")
    void updateProductNoneLock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                try {
                    productService.updateProductNoneLock(1L);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isNotEqualTo(0);
    }

    @Test
    @DisplayName("공유락을 이용하여 재고를 수정하여도, 데드락이 발생할 수 있어 재고는 0으로 수렴하지 않는다.")
    void updateProductSharedLock() throws InterruptedException {
        int threads = 200;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            executorService.execute(() -> {
                try {
                    productService.updateProductSharedLock(1L);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();

        ProductEntity product = productService.findById(1L);

        assertThat(product.getStock()).isNotEqualTo(0);
    }

    @Test
    @DisplayName("배타적락을 사용하는 경우, 뒤의 락을 이용하는 트랜잭션들은 대기하고 있다가 진행되기 때문에 재고는 0으로 수렴한다.")
    void updateProductExclusiveLock() throws InterruptedException {
        int threads = 200;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
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