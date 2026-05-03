package com.taehyun.domain.product.domain.repository;

import com.taehyun.domain.product.domain.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(UUID id);

    List<Product> findAll();

    void delete(Product product);
}
