package com.taehyun.domain.product.application.query.service;

import com.taehyun.domain.product.application.query.usecase.ProductQueryUseCase;
import com.taehyun.domain.product.domain.model.Product;
import com.taehyun.domain.product.domain.repository.query.ProductQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductQueryService implements ProductQueryUseCase {

    private final ProductQueryRepository productQueryRepository;


    private UUID toUuid(String creatorId, String prefix) {
        return UUID.fromString(prefix + "_" + creatorId);
    }

    @Override
    public Product findById(UUID id) {
        return productQueryRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return productQueryRepository.findAll();
    }
}
