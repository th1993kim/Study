package core.order.application;

import core.order.application.command.SaveOrderCommand;

public interface OrderService {
    void saveOrder(SaveOrderCommand saveOrderCommand);
}
