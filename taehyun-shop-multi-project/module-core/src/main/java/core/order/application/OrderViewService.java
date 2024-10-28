package core.order.application;

import core.order.application.domain.OrderDetail;

public interface OrderViewService {
    OrderDetail getOrderDetail(Long seqOrderId);

    OrderDetail findOrderSlowly(Long seqOrderId);
}
