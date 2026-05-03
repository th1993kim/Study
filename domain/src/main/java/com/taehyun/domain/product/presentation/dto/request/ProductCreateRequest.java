package com.taehyun.domain.product.presentation.dto.request;

import java.math.BigDecimal;

public record ProductCreateRequest (

    String sellerId,
    String creatorId,
    String name,
    String description,
    BigDecimal price,
    int stock,
    String status
) {

}
