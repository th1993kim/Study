package core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private String orderName;
    private Integer price;
    private Integer regId;
    private LocalDateTime regDateTime;
    private Integer updateId;
    private LocalDateTime updateDateTime;
}
