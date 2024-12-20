package core.product.infrastructure;

import core.product.entity.ProductEntity;
import core.product.infrastructure.jpa.ProductJpaRepository;
import core.product.infrastructure.mybatis.ProductMyBatisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductMySQLRepository implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;
    private final ProductMyBatisRepository productMyBatisRepository;


    @Override
    public Optional<ProductEntity> findById(Long seqProduct) {
        return productJpaRepository.findById(seqProduct);
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        return productJpaRepository.save(product);
    }

    @Override
    public void decreaseStock(Long seqProduct) {

    }

    @Override
    public ProductEntity findByIdWithPessimisticReadLock(Long seqProduct) {
        return productJpaRepository.findByIdWithPessimisticReadLock(seqProduct);
    }

    @Override
    public ProductEntity findByIdWithPessimisticWriteLock(Long seqProduct) {
        return productJpaRepository.findByIdWithPessimisticWriteLock(seqProduct);
    }

    @Override
    public ProductEntity findByIdWithPessimisticForceIncrementLock(Long seqProduct) {
        return productJpaRepository.findByIdWithPessimisticForceIncrementLock(seqProduct);
    }

    @Override
    public ProductEntity findByIdWithOptimisticLock(Long seqProduct) {
        return productJpaRepository.findByIdWithOptimisticLock(
                seqProduct);
    }

    @Override
    public ProductEntity findByIdWithOptimisticForceIncrementLock(Long seqProduct) {
        return productJpaRepository.findByIdWithOptimisticForceIncrementLock(seqProduct);
    }

    @Override
    public ProductEntity findByIdWithReadLock(Long seqProduct) {
        return productJpaRepository.findByIdWithReadLock(seqProduct);
    }

    @Override
    public ProductEntity findByIdWithWriteLock(Long seqProduct) {
        return productJpaRepository.findByIdWithWriteLock(seqProduct);
    }

    @Override
    public ProductEntity findByIdWithSharedLock(Long seqProduct) {
        return productMyBatisRepository.findByIdWithSharedLock(seqProduct);
    }

    @Override
    public int changeStock(ProductEntity productEntity) {
        return productMyBatisRepository.changeStock(productEntity);
    }

    @Override
    public ProductEntity findByIdWithExclusiveLock(Long seqProduct) {
        return productMyBatisRepository.findByIdWithExclusiveLock(seqProduct);
    }
}
