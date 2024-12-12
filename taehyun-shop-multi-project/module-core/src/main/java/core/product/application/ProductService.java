package core.product.application;

import core.product.entity.ProductEntity;

public interface ProductService {

    void updateProductPessimisticReadLock(Long id);

    void updateProductPessimisticWriteLock(Long id);

    void updateProductPessimisticForceIncrementLock(Long id);

    void updateProductOptimisticLock(Long id);

    void updateProductOptimisticForceIncrementLock(Long id);

    ProductEntity findById(long id);
}
