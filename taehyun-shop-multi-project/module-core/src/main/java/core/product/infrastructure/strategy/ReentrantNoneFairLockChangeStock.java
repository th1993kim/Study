package core.product.infrastructure.strategy;

import core.product.entity.ProductEntity;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantNoneFairLockChangeStock implements ChangeStockWithRock {

    private final ReentrantLock lock = new ReentrantLock(false);

    @Override
    public void changeStock(ProductEntity productEntity, int addStock) {

        lock.lock();

        try {
            if (productEntity.getStock() >= -addStock) {
                productEntity.changeStock(productEntity.getStock() + addStock);
            }
        } finally {
            lock.unlock();
        }
    }
}
