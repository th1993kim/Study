package com.taehyun.domain.product.infrastructure.acl.client;

import java.util.Optional;
import java.util.UUID;

public interface ExternalSellerClient {
    Optional<ExternalSellerPayload> findSeller(UUID sellerID);
}
