package api.order.api.request;

import core.order.application.command.OrderCompleteCommand;
import core.payment.entity.PaymentMethod;

public record CompleteOrderRequest (
        PaymentMethod paymentMethod,
        long seqShopOrder
) {

    public OrderCompleteCommand toCompleteOrderCommand() {
        return new OrderCompleteCommand(seqShopOrder, paymentMethod);
    }
}
