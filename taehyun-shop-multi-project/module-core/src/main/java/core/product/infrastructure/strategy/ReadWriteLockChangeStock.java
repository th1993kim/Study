package core.product.infrastructure.strategy;

import core.product.entity.ProductEntity;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockChangeStock implements ChangeStockWithRock {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    @Override
    public void changeStock(ProductEntity productEntity, int addStock) {
        readWriteLock.writeLock().lock();
        try {
            if (productEntity.getStock() >= -addStock) {
                productEntity.changeStock(productEntity.getStock() + addStock);
            }
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
