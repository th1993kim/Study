package core.product.infrastructure.jpa;

import core.product.entity.ProductEntity;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {


    @Lock(LockModeType.PESSIMISTIC_READ)
    @QueryHints({
            @QueryHint(name = "jakarta.persistence.lock.timeout", value = "1000")
    })
    @Query("SELECT product FROM ProductEntity product WHERE product.seqProduct = :seqProduct")
    ProductEntity findByIdWithPessimisticReadLock(@Param("seqProduct") Long seqProduct);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT product FROM ProductEntity product WHERE product.seqProduct = :seqProduct")
    ProductEntity findByIdWithPessimisticWriteLock(@Param("seqProduct") Long seqProduct);

    @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    @Query("SELECT product FROM ProductEntity product WHERE product.seqProduct = :seqProduct")
    ProductEntity findByIdWithPessimisticForceIncrementLock(@Param("seqProduct") Long seqProduct);

    @Lock(LockModeType.OPTIMISTIC)
    @Query("SELECT product FROM ProductEntity product WHERE product.seqProduct = :seqProduct")
    ProductEntity findByIdWithOptimisticLock(@Param("seqProduct") Long seqProduct);

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Query("SELECT product FROM ProductEntity product WHERE product.seqProduct = :seqProduct")
    ProductEntity findByIdWithOptimisticForceIncrementLock(@Param("seqProduct") Long seqProduct);

    @Lock(LockModeType.WRITE)
    @Query("SELECT product FROM ProductEntity product WHERE product.seqProduct = :seqProduct")
    ProductEntity findByIdWithWriteLock(@Param("seqProduct") Long seqProduct);

    @Lock(LockModeType.READ)
    @Query("SELECT product FROM ProductEntity product WHERE product.seqProduct = :seqProduct")
    ProductEntity findByIdWithReadLock(@Param("seqProduct") Long seqProduct);
}
