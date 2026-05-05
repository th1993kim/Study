package com.taehyun.domain.product.infrastructure.acl;

import com.taehyun.domain.product.application.acl.SellerAcl;
import com.taehyun.domain.product.application.acl.SellerIdentity;
import com.taehyun.domain.product.application.exception.InactiveSellerException;
import com.taehyun.domain.product.application.exception.SellerNotFoundException;
import com.taehyun.domain.product.infrastructure.acl.client.ExternalSellerClient;
import com.taehyun.domain.product.infrastructure.acl.client.ExternalSellerPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SellerAclAdapter implements SellerAcl {

    private final ExternalSellerClient externalSellerClient;

    private static final String ACTIVE_STATUS = "ACTIVE";

    @Override
    public SellerIdentity loadActiveIdentity(UUID sellerId) {
        ExternalSellerPayload seller = externalSellerClient.findSeller(sellerId)
                .orElseThrow(() -> new SellerNotFoundException(sellerId));

        if (!ACTIVE_STATUS.equals(seller.sellerStatusCode())) {
            throw new InactiveSellerException(sellerId);
        }

        return new SellerIdentity(parseSellerId(seller.sellerId()));

    }

    private UUID parseSellerId(String sellerId) {
        return UUID.fromString(sellerId);
    }
}
