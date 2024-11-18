package core.order.application.command;

import core.order.entity.OrderEntity;
import core.product.entity.ProductEntity;
import lombok.Builder;

@Builder
public record OrderProductCommand(
        long seqProduct,
        int price,
        int regId,
        long updateId
) {
    public OrderEntity toEntity() {

        return OrderEntity.builder()
                .product(ProductEntity.builder()
                        .id(seqProduct)
                        .build())
                .price(price)
                .updateId(updateId)
                .build();
    }
}
