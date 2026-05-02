package com.taehyun.domain.product.service;

import com.taehyun.domain.product.controller.dto.ProductCreateRequest;
import com.taehyun.domain.product.controller.dto.ProductUpdateRequest;
import com.taehyun.domain.product.domain.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    Product create(ProductCreateRequest request);

    Product findById(UUID id);

    List<Product> findAll();

    Product update(UUID productId, ProductUpdateRequest request);

    void delete(UUID productId);
}
