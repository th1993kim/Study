package com.taehyun.domain.product.service;

import com.taehyun.domain.product.application.port.in.ProductUseCase;
import com.taehyun.domain.product.adapter.in.web.dto.ProductCreateRequest;
import com.taehyun.domain.product.adapter.in.web.dto.ProductUpdateRequest;
import com.taehyun.domain.product.application.port.out.ProductPersistencePort;
import com.taehyun.domain.product.domain.entity.Product;
import com.taehyun.domain.product.adapter.out.persistence.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductService implements ProductUseCase {

    private final ProductPersistencePort productPersistencePort;

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
        return productPersistencePort.save(product);
    }

    private UUID toUuid(String creatorId, String prefix) {
        return UUID.fromString(prefix + "_" + creatorId);
    }

    @Override
    public Product findById(UUID id) {
        return productPersistencePort.findById(id)
                .orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return productPersistencePort.findAll();
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
        return productPersistencePort.findById(productId)
                .orElseThrow();
    }

    @Override
    @Transactional
    public void delete(UUID productId) {
        Product product = findByIdOrThrow(productId);
        productPersistencePort.delete(product);
    }
}
