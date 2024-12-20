package core.product.application;

import core.product.entity.ProductEntity;

public interface ProductService {

    void updateProductPessimisticReadLock(Long id);

    void updateProductPessimisticWriteLock(Long id);

    void updateProductPessimisticForceIncrementLock(Long id);

    void updateProductOptimisticLock(Long id);

    void updateProductOptimisticForceIncrementLock(Long id);

    void updateProductReadLock(Long id);

    void updateProductWriteLock(Long id);

    void updateProductSharedLock(Long id);

    void updateProductExclusiveLock(Long id);

    void updateProductVersionLock(Long id);

    void updateProductNoneLock(Long id);

    ProductEntity findById(long id);
}
