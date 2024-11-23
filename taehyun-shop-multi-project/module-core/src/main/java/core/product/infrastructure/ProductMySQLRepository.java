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
}
