package core.product.infrastructure.strategy;

import core.product.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class MonitorLockChangeStock implements ChangeStockWithRock {
    @Override
    public void changeStock(ProductEntity productEntity, int addStock) {
        synchronized (this) {
            if (productEntity.getStock() >= -addStock) {
                productEntity.changeStock(productEntity.getStock() + addStock);
            }
        }
    }
}
