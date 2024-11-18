package core.order.application;

import core.order.application.command.OrderCompleteCommand;
import core.order.application.command.OrderProductCommand;
import core.order.application.domain.OrderCompleteResult;
import core.order.application.domain.OrderProductResult;

public interface OrderService {

    OrderProductResult orderProduct(OrderProductCommand orderProductCommand);
    OrderCompleteResult orderComplete(OrderCompleteCommand orderCompleteCommand);
}
