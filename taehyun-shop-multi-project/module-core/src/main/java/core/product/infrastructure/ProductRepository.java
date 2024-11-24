package core.product.infrastructure;

import core.product.entity.ProductEntity;

import java.util.Optional;

public interface ProductRepository {
    Optional<ProductEntity> findById(Long seqProduct);

    ProductEntity save(ProductEntity product);
    void decreaseStock(Long id);
}
