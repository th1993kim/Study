package com.taehyun.domain.product.application.exception;


import java.util.UUID;

public class SellerNotFoundException extends RuntimeException {

    public SellerNotFoundException(UUID sellerId) {
        super("Seller Not Found . Seller ID:" + sellerId);
    }
}
