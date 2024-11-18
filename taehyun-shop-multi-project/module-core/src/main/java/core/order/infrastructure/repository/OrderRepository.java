package core.order.infrastructure.repository;

import core.order.application.domain.OrderDetail;
import core.order.entity.OrderEntity;

import java.util.Optional;

public interface OrderRepository {
    OrderEntity saveOrder(OrderEntity orderEntity);

    Optional<OrderEntity> findOne(long seqOrderId);

    OrderDetail findOneSlowly(Long seqOrderId);
}
