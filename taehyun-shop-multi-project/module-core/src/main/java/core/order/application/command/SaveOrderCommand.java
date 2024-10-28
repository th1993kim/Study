package core.order.application.command;

import core.entity.OrderEntity;
import lombok.Builder;

@Builder
public record SaveOrderCommand(
        String orderName,
        int price,
        int regId,
        int updateId
) {
    public OrderEntity toEntity() {

        return OrderEntity.builder()
                .orderName(orderName)
                .price(price)
                .regId(regId)
                .updateId(updateId)
                .build();
    }
}
