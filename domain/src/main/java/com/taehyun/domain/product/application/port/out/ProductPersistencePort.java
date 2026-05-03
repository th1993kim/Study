package com.taehyun.domain.product.application.port.out;

import com.taehyun.domain.product.domain.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductPersistencePort {

    Product save(Product product);
    Optional<Product> findById(UUID id);

    List<Product> findAll();
    void delete(Product product);
}
