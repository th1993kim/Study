package core.order.application.domain;

import core.order.entity.OrderEntity;

public record OrderProductResult(
        long seqOrderId,
        String productName,
        int paymentAmount,
        int stock
) {


    public static OrderProductResult of(OrderEntity orderEntity) {
        return new OrderProductResult(orderEntity.getId(), orderEntity.getProduct().getProductName(), orderEntity.getPrice(), orderEntity.getProduct().getStock());
    }
}
