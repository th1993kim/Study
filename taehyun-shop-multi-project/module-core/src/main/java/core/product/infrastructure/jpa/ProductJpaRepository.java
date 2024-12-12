package core.product.infrastructure.jpa;

import core.product.entity.ProductEntity;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {


    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("SELECT product FROM ProductEntity product WHERE product.id = :id")
    ProductEntity findByIdWithPessimisticReadLock(@Param("id") Long id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT product FROM ProductEntity product WHERE product.id = :id")
    ProductEntity findByIdWithPessimisticWriteLock(@Param("id") Long id);

    @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    @Query("SELECT product FROM ProductEntity product WHERE product.id = :id")
    ProductEntity findByIdWithPessimisticForceIncrementLock(@Param("id") Long id);

    @Lock(LockModeType.OPTIMISTIC)
    @Query("SELECT product FROM ProductEntity product WHERE product.id = :id")
    ProductEntity findByIdWithOptimisticLock(@Param("id") Long id);

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Query("SELECT product FROM ProductEntity product WHERE product.id = :id")
    ProductEntity findByIdWithOptimisticForceIncrementLock(@Param("id") Long id);
}
