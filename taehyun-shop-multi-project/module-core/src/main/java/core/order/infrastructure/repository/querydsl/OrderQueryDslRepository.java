package core.order.infrastructure.repository.querydsl;

import core.order.infrastructure.result.OrderDetail;

public interface OrderQueryDslRepository {

    OrderDetail findOneSlowly(Long seqOrderId);
}
