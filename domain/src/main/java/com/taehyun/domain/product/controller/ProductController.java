package com.taehyun.domain.product.controller;

import com.taehyun.domain.product.controller.dto.ProductCreateRequest;
import com.taehyun.domain.product.controller.dto.ProductUpdateRequest;
import com.taehyun.domain.product.domain.entity.Product;
import com.taehyun.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/product")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductCreateRequest request) {
        return ResponseEntity.ok(productService.create(request));
    }

    @GetMapping("/{productId}")
    public Product findById(@PathVariable("productId") UUID productId) {
        return productService.findById(productId);
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @PutMapping("/{productId}")
    public Product update(@PathVariable UUID productId, @RequestBody ProductUpdateRequest request) {
        return productService.update(productId, request);
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable UUID productId) {
        productService.delete(productId);
    }
}
