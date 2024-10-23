package order;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@EnableJpaAuditing
@Entity
@Table(name = "shop_order")
public class Order {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    private String orderName;
    private Integer price;
    private Integer regId;
    private LocalDateTime regDateTime;
    private Integer updateId;
    private LocalDateTime updateDateTime;
}
