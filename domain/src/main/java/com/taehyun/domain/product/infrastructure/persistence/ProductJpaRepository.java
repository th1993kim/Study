package com.taehyun.domain.product.infrastructure.persistence;

import com.taehyun.domain.product.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, UUID> {

}
