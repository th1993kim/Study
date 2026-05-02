package com.taehyun.domain.product.controller.dto;

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
