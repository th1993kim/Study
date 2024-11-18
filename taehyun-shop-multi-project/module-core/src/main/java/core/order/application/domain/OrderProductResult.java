package core.order.application.domain;

import core.order.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderProductResult {
    private long seqOrderId;
    private String productName;
    private int paymentAmount;
    private int stock;

    public static OrderProductResult of(OrderEntity orderEntity) {
        return new OrderProductResult(orderEntity.getId(), orderEntity.getProduct().getProductName(), orderEntity.getPrice(), orderEntity.getProduct().getCount());
    }
}
