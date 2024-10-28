package core.order.infrastructure.repository;

import core.entity.OrderEntity;
import core.order.application.domain.OrderDetail;

import java.util.Optional;

public interface OrderRepository {
    OrderEntity saveOrder(OrderEntity orderEntity);

    Optional<OrderEntity> findOne(long seqOrderId);

    OrderDetail findOneSlowly(Long seqOrderId);
}
