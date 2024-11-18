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

}
