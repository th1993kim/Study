package core.product.infrastructure;

import core.product.entity.ProductEntity;
import core.product.infrastructure.strategy.ChangeStockWithRock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@RequiredArgsConstructor
public class ProductJavaRepository implements ProductRepository {

    private AtomicLong key = new AtomicLong(0);
    private Map<Long, ProductEntity> productMap = new HashMap<>();
    private ChangeStockWithRock changeStockWithRock;


    @Override
    public Optional<ProductEntity> findById(Long seqProduct) {
        return Optional.ofNullable(productMap.get(seqProduct));
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        long nextKey = key.addAndGet(1L);
        return productMap.put(nextKey, product);
    }

    @Override
    public void decreaseStock(Long id) {
        ProductEntity productEntity = productMap.get(id);
        changeStockWithRock.changeStock(productEntity, -1);
    }

    public void setChangeStockWithRock(ChangeStockWithRock changeStockWithRock) {
        this.changeStockWithRock = changeStockWithRock;
    }
}
