package core.order.entity;

import core.entity.MemberEntity;
import core.payment.entity.PaymentEntity;
import core.product.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Builder
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "shop_order")
public class OrderEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "seq_shop_order")
    private Long id;
    private Integer price;
    private String orderName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seq_product")
    private ProductEntity product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seq_member")
    private MemberEntity member;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "order")
    private PaymentEntity payment;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @CreatedDate
    private LocalDateTime regDateTime;
    @LastModifiedBy
    private Long updateId;
    @LastModifiedDate
    private LocalDateTime updateDateTime;

    public void success() {
        orderStatus = OrderStatus.COMPLETE;
    }

    public boolean isCompleted() {
        return OrderStatus.COMPLETE == orderStatus;
    }
}
