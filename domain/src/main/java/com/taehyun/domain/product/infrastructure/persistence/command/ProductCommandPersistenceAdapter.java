package com.taehyun.domain.product.infrastructure.persistence.command;

import com.taehyun.domain.product.domain.model.Product;
import com.taehyun.domain.product.domain.repository.command.ProductCommandRepository;
import com.taehyun.domain.product.infrastructure.persistence.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ProductCommandPersistenceAdapter implements ProductCommandRepository {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Product save(Product product) {
        return productJpaRepository.save(product);
    }

    @Override
    public void delete(Product product) {

        productJpaRepository.delete(product);
    }

    @Override
    public Optional<Product> findById(UUID productId) {
        return productJpaRepository.findById(productId);
    }
}
