package core.product.infrastructure;

import core.product.entity.ProductEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface ProductRepository {
    Optional<ProductEntity> findById(Long seqProduct);

    ProductEntity save(ProductEntity product);
    void decreaseStock(Long id);

    ProductEntity findByIdWithPessimisticReadLock(Long id);

    ProductEntity findByIdWithPessimisticWriteLock(Long id);

    ProductEntity findByIdWithPessimisticForceIncrementLock(Long id);

    ProductEntity findByIdWithOptimisticLock(Long id);

    ProductEntity findByIdWithOptimisticForceIncrementLock(Long id);

    ProductEntity findByIdWithReadLock(Long id);

    ProductEntity findByIdWithWriteLock(Long id);

    ProductEntity findByIdWithSharedLock(Long id);

    int changeStock(ProductEntity productEntity);

    ProductEntity findByIdWithExclusiveLock(Long id);
}
