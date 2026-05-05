package com.taehyun.domain.product.infrastructure.acl.client;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class StubExternalSellerClient implements ExternalSellerClient {

    @Override
    public Optional<ExternalSellerPayload> findSeller(UUID sellerID) {
        return Optional.of(new ExternalSellerPayload(sellerID.toString(), "ACTIVE"));
    }
}
