package core.product.infrastructure;

import core.product.entity.ProductEntity;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

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
}
