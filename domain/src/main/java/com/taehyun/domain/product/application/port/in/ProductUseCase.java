package com.taehyun.domain.product.application.port.in;

import com.taehyun.domain.product.adapter.in.web.dto.ProductCreateRequest;
import com.taehyun.domain.product.adapter.in.web.dto.ProductUpdateRequest;
import com.taehyun.domain.product.domain.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductUseCase {

    Product create(ProductCreateRequest request);

    Product findById(UUID id);

    List<Product> findAll();

    Product update(UUID productId, ProductUpdateRequest request);

    void delete(UUID productId);
}
