package com.taehyun.domain.product.infrastructure.persistence.query;

import com.taehyun.domain.product.domain.model.Product;
import com.taehyun.domain.product.domain.repository.query.ProductQueryRepository;
import com.taehyun.domain.product.infrastructure.persistence.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ProductQueryPersistenceAdapter implements ProductQueryRepository {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Optional<Product> findById(UUID id) {
        return productJpaRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll();
    }
}
