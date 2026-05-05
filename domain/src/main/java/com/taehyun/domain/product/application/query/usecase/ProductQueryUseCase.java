package com.taehyun.domain.product.application.query.usecase;

import com.taehyun.domain.product.domain.model.Product;
import com.taehyun.domain.product.presentation.dto.request.ProductCreateRequest;
import com.taehyun.domain.product.presentation.dto.request.ProductUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface ProductQueryUseCase {

    Product findById(UUID id);

    List<Product> findAll();
}
