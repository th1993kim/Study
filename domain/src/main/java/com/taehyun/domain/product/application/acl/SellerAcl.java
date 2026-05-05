package com.taehyun.domain.product.application.acl;

import java.util.UUID;

public interface SellerAcl {

    SellerIdentity loadActiveIdentity(UUID sellerId);
}
