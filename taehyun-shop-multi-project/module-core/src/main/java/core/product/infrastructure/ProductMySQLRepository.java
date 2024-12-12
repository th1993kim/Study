package core.product.infrastructure;

import core.product.entity.ProductEntity;
import core.product.infrastructure.jpa.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductMySQLRepository implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;


    @Override
    public Optional<ProductEntity> findById(Long seqProduct) {
        return productJpaRepository.findById(seqProduct);
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        return productJpaRepository.save(product);
    }

    @Override
    public void decreaseStock(Long id) {

    }

    @Override
    public ProductEntity findByIdWithPessimisticReadLock(Long id) {
        return productJpaRepository.findByIdWithPessimisticReadLock(id);
    }

    @Override
    public ProductEntity findByIdWithPessimisticWriteLock(Long id) {
        return productJpaRepository.findByIdWithPessimisticWriteLock(id);
    }

    @Override
    public ProductEntity findByIdWithPessimisticForceIncrementLock(Long id) {
        return productJpaRepository.findByIdWithPessimisticForceIncrementLock(id);
    }

    @Override
    public ProductEntity findByIdWithOptimisticLock(Long id) {
        return productJpaRepository.findByIdWithOptimisticLock(id);
    }

    @Override
    public ProductEntity findByIdWithOptimisticForceIncrementLock(Long id) {
        return productJpaRepository.findByIdWithOptimisticForceIncrementLock(id);
    }
}
