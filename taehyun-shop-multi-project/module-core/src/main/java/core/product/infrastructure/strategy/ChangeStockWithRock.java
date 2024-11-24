package core.product.infrastructure.strategy;

import core.product.entity.ProductEntity;

public interface ChangeStockWithRock {
    void changeStock(ProductEntity productEntity, int addStock);
}
