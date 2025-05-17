package core.product.application;

public interface ProductGlobalService {
    boolean decreaseStock(long seqProduct, int quantity);
}
