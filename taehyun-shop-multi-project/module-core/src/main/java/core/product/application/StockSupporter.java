package core.product.application;

public interface StockSupporter {
    boolean acquireLock(long seqProduct);

    void releaseLock(long seqProduct);

    long addStock(long seqProduct, int addCount);
}
