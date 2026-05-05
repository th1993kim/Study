package com.taehyun.domain.product.presentation.controller;

import com.taehyun.domain.product.application.query.usecase.ProductQueryUseCase;
import com.taehyun.domain.product.presentation.dto.request.ProductCreateRequest;
import com.taehyun.domain.product.presentation.dto.request.ProductUpdateRequest;
import com.taehyun.domain.product.domain.model.Product;
import com.taehyun.domain.product.application.command.usecase.ProductCommandUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/product")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductCommandUseCase productCommandUseCase;
    private final ProductQueryUseCase productQueryUseCase;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductCreateRequest request) {
        return ResponseEntity.ok(productCommandUseCase.create(request));
    }

    @GetMapping("/{productId}")
    public Product findById(@PathVariable("productId") UUID productId) {
        return productQueryUseCase.findById(productId);
    }

    @GetMapping
    public List<Product> findAll() {
        return productQueryUseCase.findAll();
    }

    @PutMapping("/{productId}")
    public Product update(@PathVariable UUID productId, @RequestBody ProductUpdateRequest request) {
        return productCommandUseCase.update(productId, request);
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable UUID productId) {
        productCommandUseCase.delete(productId);
    }
}
