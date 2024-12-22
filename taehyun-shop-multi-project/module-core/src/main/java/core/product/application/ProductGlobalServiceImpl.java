package core.product.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductGlobalServiceImpl implements ProductGlobalService {

    private final StockSupporter redisStockSupporter;
    private final ProductService productService;

    @Override
    public boolean decreaseStock(long seqProduct, int quantity) {
        boolean isGetLock = redisStockSupporter.acquireLock(seqProduct);
        try {
            long currentStock = redisStockSupporter.addStock(seqProduct, -quantity);
            if (currentStock < 0) {
                throw new RuntimeException("재고가 부족해 제품 판매가 불가능합니다.");
            }
            productService.updateProductExclusiveLock(seqProduct);
            return true;
        } finally {
            if (isGetLock) {
                redisStockSupporter.releaseLock(seqProduct);
            }
        }
    }
}
