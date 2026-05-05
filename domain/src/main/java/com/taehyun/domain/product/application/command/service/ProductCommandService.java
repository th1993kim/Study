package com.taehyun.domain.product.application.command.service;

import com.taehyun.domain.product.application.command.usecase.ProductCommandUseCase;
import com.taehyun.domain.product.domain.model.Product;
import com.taehyun.domain.product.domain.repository.command.ProductCommandRepository;
import com.taehyun.domain.product.presentation.dto.request.ProductCreateRequest;
import com.taehyun.domain.product.presentation.dto.request.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductCommandService implements ProductCommandUseCase {

    private final ProductCommandRepository productCommandRepository;

    @Override
    @Transactional
    public Product create(ProductCreateRequest request) {
        Product product = Product.create(
                toUuid(request.sellerId(), "sellerId"),
                request.name(),
                request.description(),
                request.price(),
                request.stock(),
                request.status(),
                toUuid(request.creatorId(), "creatorId")
        );
        return productCommandRepository.save(product);
    }

    private UUID toUuid(String creatorId, String prefix) {
        return UUID.fromString(prefix + "_" + creatorId);
    }

    @Override
    @Transactional
    public Product update(UUID productId, ProductUpdateRequest request) {
        Product product = findByIdOrThrow(productId);
        product.update(
                request.name(),
                request.description(),
                request.price(),
                request.stock(),
                request.status(),
                toUuid(request.modifierId(), "modifierId")
        );
        return product;
    }

    private Product findByIdOrThrow(UUID productId) {
        return productCommandRepository.findById(productId)
                .orElseThrow();
    }

    @Override
    @Transactional
    public void delete(UUID productId) {
        Product product = findByIdOrThrow(productId);
        productCommandRepository.delete(product);
    }
}
