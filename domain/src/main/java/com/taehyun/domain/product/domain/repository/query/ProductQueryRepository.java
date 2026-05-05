package com.taehyun.domain.product.domain.repository.query;

import com.taehyun.domain.product.domain.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductQueryRepository {

    Optional<Product> findById(UUID id);

    List<Product> findAll();
}
