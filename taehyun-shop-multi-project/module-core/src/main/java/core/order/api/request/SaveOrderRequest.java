package core.order.api.request;

import core.order.application.command.SaveOrderCommand;

public record SaveOrderRequest(
        String orderName,
        int price,
        int regId
) {

    public SaveOrderCommand toSaveOrderCommand() {
        return SaveOrderCommand.builder()
                .orderName(orderName)
                .price(price)
                .regId(regId)
                .updateId(regId)
                .build();
    }
}
