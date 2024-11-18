package core.order.application;

import core.order.application.domain.OrderDetail;
import core.order.infrastructure.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderViewServiceImpl implements OrderViewService {

    private final OrderRepository orderRepository;

    @Override
    public OrderDetail getOrderDetail(Long seqOrderId) {
        return orderRepository.findOne(seqOrderId)
                .map(order -> new OrderDetail(order.getOrderName(), order.getPrice(), order.getMember().getId()))
                .orElse(null);
    }
}
