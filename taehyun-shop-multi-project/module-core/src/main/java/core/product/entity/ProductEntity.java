package core.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_product")
    private Long seqProduct;
    private String productName;
    private Integer price;
    private Integer stock;
    @CreatedBy
    private Long regId;
    @CreatedDate
    private LocalDateTime regDateTime;
    @LastModifiedBy
    private Long updateId;
    @LastModifiedDate
    private LocalDateTime updateDateTime;
    @Version
    @ColumnDefault(value = "0")
    private Long version;

    public boolean decreaseStock() {
        if (stock > 0) {
            stock--;
            return true;
        }

        return false;
    }

    public void changeStock(Integer stock) {
        this.stock = stock;
    }
}
