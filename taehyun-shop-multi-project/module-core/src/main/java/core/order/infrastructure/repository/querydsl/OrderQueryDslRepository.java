package core.order.infrastructure.repository.querydsl;

import core.order.application.domain.OrderDetail;

public interface OrderQueryDslRepository {

    OrderDetail findOneSlowly(Long seqOrderId);
}
