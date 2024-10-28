package core.order.application;

import core.order.application.command.SaveOrderCommand;
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
    public void saveOrder(SaveOrderCommand saveOrderCommand) {
        orderRepository.saveOrder(saveOrderCommand.toEntity());
    }
}
