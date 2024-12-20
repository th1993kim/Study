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
        ProductEntity product = findProduct(orderProductCommand.seqProduct());
        OrderEntity orderEntity = createOrder(orderProductCommand, product);
        return OrderProductResult.of(orderEntity);
    }

    private OrderEntity createOrder(OrderProductCommand orderProductCommand, ProductEntity product) {
        return orderRepository.saveOrder(OrderEntity.builder()
                .product(product)
                .price(product.getPrice())
                .member(MemberEntity.builder()
                        .id(orderProductCommand.regId())
                        .build())
                .orderStatus(OrderStatus.REQUEST)
                .build());
    }

    @Override
    public OrderCompleteResult orderComplete(OrderCompleteCommand orderCompleteCommand) {
        // 1. 주문 조회 및 완료 처리
        OrderEntity order = findOrder(orderCompleteCommand.seqShopOrder());
        completeOrder(order);

        // 2. 결제 데이터 생성 및 저장
        PaymentEntity payment = createPayment(orderCompleteCommand, order);
        paymentRepository.save(payment);

        // 3. 상품 조회 및 수량 감소
        ProductEntity product = findProduct(order.getProduct().getSeqProduct());
        decreaseProductStock(product);


        return new OrderCompleteResult(order.getId());
    }

    private void completeOrder(OrderEntity order) {
        if (order.isCompleted()) {
            throw new RuntimeException("주문은 완료된 상품입니다.");
        }
        order.success();
    }

    private void decreaseProductStock(ProductEntity product) {
        if (product.getStock() < 1) {
            throw new RuntimeException("재고가 부족하여 주문을 진행할 수 없습니다.");
        }
        product.decreaseStock();
    }

    private PaymentEntity createPayment(OrderCompleteCommand orderCompleteCommand, OrderEntity order) {
        return PaymentEntity.builder()
                .paymentMethod(orderCompleteCommand.paymentMethod())
                .amount(order.getPrice())
                .order(order)
                .paymentStatus(PaymentStatus.COMPLETE)
                .paymentCompleteTime(LocalDateTime.now())
                .paymentRefundedTime(LocalDateTime.now())
                .regDateTime(LocalDateTime.now())
                .build();
    }

    private ProductEntity findProduct(Long seqProduct) {
        ProductEntity product = productRepository.findById(seqProduct)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 상품입니다."));
        validateProduct(product);
        return product;
    }

    private OrderEntity findOrder(Long seqShopOrder) {
        return orderRepository.findOne(seqShopOrder)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 주문 요청입니다."));
    }

    private void validateProduct(ProductEntity product) {
        if (product.getStock() == null || product.getStock() < 1) {
            throw new RuntimeException("수량이 부족하여 상품을 구매할 수 없습니다.");
        }
    }
}
