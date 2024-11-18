package core.order.application;

import core.order.application.command.OrderProductCommand;
import core.order.application.domain.OrderProductResult;
import core.order.entity.OrderEntity;
import core.order.infrastructure.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;


    @Override
    public OrderProductResult orderProduct(OrderProductCommand orderProductCommand) {
        OrderEntity orderEntity = orderRepository.saveOrder(orderProductCommand.toEntity());

        return OrderProductResult.of(orderEntity);
    }
}
