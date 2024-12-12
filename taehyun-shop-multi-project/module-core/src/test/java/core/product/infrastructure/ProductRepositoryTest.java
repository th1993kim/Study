package core.product.infrastructure;

import core.product.entity.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Import(ProductMySQLRepository.class)
@Sql(scripts = {"classpath:sql/product.sql"})
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productMySqlRepository;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    void decreaseStock() throws InterruptedException {
        productMySqlRepository.findById(1L)
                .ifPresent(product -> System.out.println("product = " + product.getId()));
        ExecutorService executorService = Executors.newFixedThreadPool(50);

        CountDownLatch countDownLatch = new CountDownLatch(50);
        for (int i = 0; i < 50; i++) {
            executorService.submit(() -> {
                ProductEntity product = productMySqlRepository.findById(1L)
                        .orElse(null);
                if (product != null) {
                    EntityManager entityManager = entityManagerFactory.createEntityManager();
                    entityManager.detach(product);
                    product.decreaseStock();
                    entityManager.flush();
                    entityManager.clear();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        productMySqlRepository.findById(1L)
                .ifPresent(product -> assertEquals(0, product.getStock()));

    }


    @Test
    void pessimisticReadLock() throws InterruptedException {
        ProductEntity productEntity = productMySqlRepository.findByIdWithPessimisticReadLock(1L);

        productEntity.decreaseStock();

        Optional<ProductEntity> entity = productMySqlRepository.findById(1L);
    }
}
