package com.taehyun.domain.product.infrastructure.acl.client;

public record ExternalSellerPayload(
        String sellerId,
        String sellerStatusCode
) {
}
