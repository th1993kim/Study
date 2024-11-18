package core.order.infrastructure.repository.querydsl;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import core.order.application.domain.OrderDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static core.order.infrastructure.entity.QOrderEntity.orderEntity;


@Repository
@RequiredArgsConstructor
public class OrderQueryDslRepositoryImpl implements OrderQueryDslRepository {

    private final JPAQueryFactory queryFactory;


    @Override
    public OrderDetail findOneSlowly(Long seqOrderId) {
        return queryFactory
                .select(Projections.constructor(OrderDetail.class,
                        orderEntity.orderName,
                        orderEntity.price,
                        orderEntity.member.id))
                .from(orderEntity)
                .where(orderEntity.id.eq(seqOrderId)
                .and(Expressions.booleanTemplate("function('SLEEP', 10) = 0")))
                .fetchOne();
    }
}
