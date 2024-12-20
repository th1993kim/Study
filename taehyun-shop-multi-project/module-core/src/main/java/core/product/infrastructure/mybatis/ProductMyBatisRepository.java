package core.product.infrastructure.mybatis;

import core.product.entity.ProductEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductMyBatisRepository {

    @Select(value ="""
    SELECT price,
           stock,
           reg_date_time,
           reg_id,
           seq_product,
           update_date_time,
           update_id,
           product_name
      FROM product
     WHERE seq_product = #{seqProduct} FOR SHARE
    """)
    ProductEntity findByIdWithSharedLock(@Param("seqProduct") Long seqProduct);

    @Update(value = """
        UPDATE product
           SET stock = #{stock}
         WHERE seq_product = #{seqProduct}
           AND stock > 0
    """)
    int changeStock(ProductEntity productEntity);


    @Select(value ="""
    SELECT price,
           stock,
           reg_date_time,
           reg_id,
           seq_product,
           update_date_time,
           update_id,
           product_name
      FROM product
     WHERE seq_product = #{seqProduct} FOR UPDATE
    """)
    ProductEntity findByIdWithExclusiveLock(@Param("seqProduct") Long seqProduct);
}
