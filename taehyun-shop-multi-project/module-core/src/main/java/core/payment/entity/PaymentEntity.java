package core.payment.entity;

import core.order.entity.OrderEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "payment")
public class PaymentEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private int amount;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seq_shop_order")
    private OrderEntity order;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentCompleteTime;
    private LocalDateTime paymentRefundedTime;
    private LocalDateTime regDateTime;
}
