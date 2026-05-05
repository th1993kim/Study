package com.taehyun.domain.product.application.command.usecase;

import com.taehyun.domain.product.domain.model.Product;
import com.taehyun.domain.product.presentation.dto.request.ProductCreateRequest;
import com.taehyun.domain.product.presentation.dto.request.ProductUpdateRequest;

import java.util.UUID;

public interface ProductCommandUseCase {

    Product create(ProductCreateRequest request);

    Product update(UUID productId, ProductUpdateRequest request);

    void delete(UUID productId);
}
