package api.order.api;

import core.order.application.command.OrderProductCommand;

public record SaveOrderRequest(
        long seqProduct,
        int price,
        int count,
        int regId
) {

    public OrderProductCommand toSaveOrderCommand() {
        return OrderProductCommand.builder()
                .seqProduct(seqProduct)
                .price(price)
                .regId(regId)
                .updateId(regId)
                .build();
    }
}
