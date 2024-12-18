package core.product.application;

import core.product.entity.ProductEntity;
import core.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.LocalDateTime;

@Transactional(isolation = Isolation.REPEATABLE_READ)
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void updateProductPessimisticReadLock(Long id) {
        ProductEntity product = productRepository.findByIdWithPessimisticReadLock(1L);
        product.decreaseStock();
    }

    @Override
    public void updateProductPessimisticWriteLock(Long id) {

        log.debug("트랜잭션  활성화 여부: {}", TransactionSynchronizationManager.isActualTransactionActive());
        ProductEntity product = productRepository.findByIdWithPessimisticWriteLock(id);
        log.debug("조회 종료 :{} 쓰레드 :{}", LocalDateTime.now().getNano(), Thread.currentThread().getName());
        product.decreaseStock();
        log.debug("수정 종료 :{} 쓰레드 :{}", LocalDateTime.now().getNano(), Thread.currentThread().getName());
    }

    @Override
    public void updateProductPessimisticForceIncrementLock(Long id) {

        ProductEntity product = productRepository.findByIdWithPessimisticForceIncrementLock(1L);
        product.decreaseStock();
    }

    @Override
    public void updateProductOptimisticLock(Long id) {
        ProductEntity product = productRepository.findByIdWithOptimisticLock(1L);
        product.decreaseStock();
    }

    @Override
    public void updateProductOptimisticForceIncrementLock(Long id) {
        ProductEntity product = productRepository.findByIdWithOptimisticForceIncrementLock(1L);
        product.decreaseStock();
    }

    @Override
    public ProductEntity findById(long id) {
        return productRepository.findById(id).orElse(null);
    }
}
