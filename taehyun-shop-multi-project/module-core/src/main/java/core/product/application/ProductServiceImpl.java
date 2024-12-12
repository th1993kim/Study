package core.product.application;

import core.product.entity.ProductEntity;
import core.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void updateProductPessimisticReadLock(Long id) {
        ProductEntity product = productRepository.findByIdWithPessimisticReadLock(1L);
        product.decreaseStock();
    }

    @Override
    public void updateProductPessimisticWriteLock(Long id) {

        ProductEntity product = productRepository.findByIdWithPessimisticWriteLock(id);
        product.decreaseStock();
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
