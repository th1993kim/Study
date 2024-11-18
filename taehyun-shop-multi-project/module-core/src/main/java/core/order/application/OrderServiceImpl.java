package core.order.application;

import core.entity.MemberEntity;
import core.order.application.command.OrderCompleteCommand;
import core.order.application.command.OrderProductCommand;
import core.order.application.domain.OrderCompleteResult;
import core.order.application.domain.OrderProductResult;
import core.order.entity.OrderEntity;
import core.order.entity.OrderStatus;
import core.order.infrastructure.repository.OrderRepository;
import core.payment.entity.PaymentEntity;
import core.payment.entity.PaymentStatus;
import core.payment.infastructure.PaymentRepository;
import core.product.entity.ProductEntity;
import core.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final PaymentRepository paymentRepository;


    @Override
    public OrderProductResult orderProduct(OrderProductCommand orderProductCommand) {
        ProductEntity product = productRepository.findById(orderProductCommand.seqProduct())
                .orElse(null);
        validateProduct(product);
        OrderEntity orderEntity = orderRepository.saveOrder(OrderEntity.builder()
                .product(product)
                .price(product.getPrice())
                .member(MemberEntity.builder()
                        .id(orderProductCommand.regId())
                        .build())
                .orderStatus(OrderStatus.REQUEST)
                .build());

        return OrderProductResult.of(orderEntity);
    }

    @Override
    public OrderCompleteResult orderComplete(OrderCompleteCommand orderCompleteCommand) {
        OrderEntity order = orderRepository.findOne(orderCompleteCommand.seqOrderId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 주문 요청입니다."));
        ProductEntity product = productRepository.findById(order.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 상품입니다."));

        PaymentEntity paymentEntity = PaymentEntity.builder()
                .paymentMethod(orderCompleteCommand.paymentMethod())
                .amount(order.getPrice())
                .order(order)
                .paymentStatus(PaymentStatus.COMPLETE)
                .paymentCompleteTime(LocalDateTime.now())
                .paymentRefundedTime(LocalDateTime.now())
                .regDateTime(LocalDateTime.now())
                .build();

        paymentRepository.save(paymentEntity);
        product.decreaseStock();
        order.success();

        return new OrderCompleteResult(order.getId());
    }

    private void validateProduct(ProductEntity product) {
        if (product == null) {
            throw new RuntimeException("존재하지 않는 상품입니다.");
        }

        if (product.getStock() == null || product.getStock() < 1) {
            throw new RuntimeException("수량이 부족하여 상품을 구매할 수 없습니다.");
        }
    }
}
