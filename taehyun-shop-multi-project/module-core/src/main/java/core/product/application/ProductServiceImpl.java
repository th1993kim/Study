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

@Transactional(isolation = Isolation.READ_COMMITTED)
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void updateProductPessimisticReadLock(Long seqProduct) {
        ProductEntity product = productRepository.findByIdWithPessimisticReadLock(seqProduct);
        product.decreaseStock();
    }

    @Override
    public void updateProductPessimisticWriteLock(Long seqProduct) {

        log.debug("트랜잭션  활성화 여부: {}", TransactionSynchronizationManager.isActualTransactionActive());
        ProductEntity product = productRepository.findByIdWithPessimisticWriteLock(seqProduct);
        log.debug("조회 종료 :{} 쓰레드 :{}", LocalDateTime.now().getNano(), Thread.currentThread().getName());
        product.decreaseStock();
        log.debug("수정 종료 :{} 쓰레드 :{}", LocalDateTime.now().getNano(), Thread.currentThread().getName());
    }

    @Override
    public void updateProductPessimisticForceIncrementLock(Long seqProduct) {

        ProductEntity product = productRepository.findByIdWithPessimisticForceIncrementLock(seqProduct);
        log.debug("조회 종료 :{} 쓰레드 :{}", LocalDateTime.now().getNano(), Thread.currentThread().getName());
        product.decreaseStock();
        log.debug("수정 종료 :{} 쓰레드 :{}", LocalDateTime.now().getNano(), Thread.currentThread().getName());
    }

    @Override
    public void updateProductOptimisticLock(Long seqProduct) {
        ProductEntity product = productRepository.findByIdWithOptimisticLock(seqProduct);
        product.decreaseStock();
    }

    @Override
    public void updateProductOptimisticForceIncrementLock(Long seqProduct) {
        ProductEntity product = productRepository.findByIdWithOptimisticForceIncrementLock(seqProduct);
        product.decreaseStock();
    }

    @Override
    public void updateProductReadLock(Long seqProduct) {
        ProductEntity product = productRepository.findByIdWithReadLock(seqProduct);
        product.decreaseStock();
    }

    @Override
    public void updateProductWriteLock(Long seqProduct) {
        ProductEntity product = productRepository.findByIdWithWriteLock(seqProduct);
        product.decreaseStock();
    }

    @Override
    @Transactional(timeout = 3)
    public void updateProductSharedLock(Long seqProduct) {
        ProductEntity product = productRepository.findByIdWithSharedLock(seqProduct);
        product.decreaseStock();
        productRepository.changeStock(product);
    }

    @Override
    public void updateProductExclusiveLock(Long seqProduct) {
        ProductEntity product = productRepository.findByIdWithExclusiveLock(seqProduct);
        if (product.getStock() <= 0) {
            throw new RuntimeException("재고가 0개보다 적어서 판매가 불가능합니다.");
        }
        product.decreaseStock();
        int decreased = productRepository.changeStock(product);
        if (decreased == 0) {
            throw new RuntimeException("재고가 부족해 수량 감소에 실패하였습니다.");
        }
    }

    @Override
    public void updateProductVersionLock(Long seqProduct) {

    }

    @Override
    public void updateProductNoneLock(Long seqProduct) {
        productRepository.findById(seqProduct)
                .ifPresent(ProductEntity::decreaseStock);
    }

    @Override
    public ProductEntity findById(long id) {
        return productRepository.findById(id).orElse(null);
    }



}
