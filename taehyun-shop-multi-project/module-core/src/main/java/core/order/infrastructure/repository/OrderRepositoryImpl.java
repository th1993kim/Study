package core.order.infrastructure.repository;

import core.entity.OrderEntity;
import core.order.application.domain.OrderDetail;
import core.order.infrastructure.repository.jpa.OrderJpaRepository;
import core.order.infrastructure.repository.querydsl.OrderQueryDslRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderQueryDslRepository orderQueryDslRepository;

    @Override
    public OrderEntity saveOrder(OrderEntity orderEntity) {
        return orderJpaRepository.save(orderEntity);
    }

    @Override
    public Optional<OrderEntity> findOne(long seqOrderId) {
        return orderJpaRepository.findById(seqOrderId);
    }

    @Override
    public OrderDetail findOneSlowly(Long seqOrderId) {
        return orderQueryDslRepository.findOneSlowly(seqOrderId);
    }

}
