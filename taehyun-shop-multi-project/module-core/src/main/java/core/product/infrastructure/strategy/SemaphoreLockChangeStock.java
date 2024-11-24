package core.product.infrastructure.strategy;

import core.product.entity.ProductEntity;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreLockChangeStock implements ChangeStockWithRock {

    private final Semaphore semaphore = new Semaphore(1);
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void changeStock(ProductEntity productEntity, int addStock) {
        try {
            semaphore.acquire();
            if (productEntity.getStock() >= -addStock) {
                productEntity.changeStock(productEntity.getStock() + addStock);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }
}
