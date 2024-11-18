package core.order.application;

import core.order.application.command.OrderProductCommand;
import core.order.application.domain.OrderProductResult;

public interface OrderService {

    OrderProductResult orderProduct(OrderProductCommand orderProductCommand);
}
