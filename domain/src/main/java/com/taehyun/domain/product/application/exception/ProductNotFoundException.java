package com.taehyun.domain.product.application.exception;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(UUID productId) {
        super("Product Not Found . Product ID:" + productId);
    }
}
