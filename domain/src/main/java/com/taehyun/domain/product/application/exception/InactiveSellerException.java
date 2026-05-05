package com.taehyun.domain.product.application.exception;

import java.util.UUID;

public class InactiveSellerException extends RuntimeException {

    public InactiveSellerException(UUID sellerId) {
        super("Inactive Seller . Seller ID:" + sellerId);
    }
}
