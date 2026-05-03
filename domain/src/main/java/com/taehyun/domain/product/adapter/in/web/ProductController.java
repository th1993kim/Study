package com.taehyun.domain.product.adapter.in.web;

import com.taehyun.domain.product.adapter.in.web.dto.ProductCreateRequest;
import com.taehyun.domain.product.adapter.in.web.dto.ProductUpdateRequest;
import com.taehyun.domain.product.domain.entity.Product;
import com.taehyun.domain.product.application.port.in.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/product")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductUseCase productUseCase;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductCreateRequest request) {
        return ResponseEntity.ok(productUseCase.create(request));
    }

    @GetMapping("/{productId}")
    public Product findById(@PathVariable("productId") UUID productId) {
        return productUseCase.findById(productId);
    }

    @GetMapping
    public List<Product> findAll() {
        return productUseCase.findAll();
    }

    @PutMapping("/{productId}")
    public Product update(@PathVariable UUID productId, @RequestBody ProductUpdateRequest request) {
        return productUseCase.update(productId, request);
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable UUID productId) {
        productUseCase.delete(productId);
    }
}
