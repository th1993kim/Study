package com.taehyun.domain.product.domain.repository.command;

import com.taehyun.domain.product.domain.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductCommandRepository {

    Product save(Product product);

    void delete(Product product);

    Optional<Product> findById(UUID productId);
}
