package com.taehyun.domain.product.application.usecase;

import com.taehyun.domain.product.presentation.dto.request.ProductCreateRequest;
import com.taehyun.domain.product.presentation.dto.request.ProductUpdateRequest;
import com.taehyun.domain.product.domain.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductUseCase {

    Product create(ProductCreateRequest request);

    Product findById(UUID id);

    List<Product> findAll();

    Product update(UUID productId, ProductUpdateRequest request);

    void delete(UUID productId);
}
