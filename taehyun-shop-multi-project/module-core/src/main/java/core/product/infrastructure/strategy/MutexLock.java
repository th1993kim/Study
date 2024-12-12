package core.product.infrastructure.strategy;


import java.util.concurrent.atomic.AtomicBoolean;

public class MutexLock {

    AtomicBoolean lock = new AtomicBoolean(false);


    public boolean acquire() {
        while (lock.compareAndSet(false, true)) {
            Thread.yield();
        }
        return lock.get();
    }

    public void release() {
        lock.set(false);
    }
}
