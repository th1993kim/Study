package com.taehyun.domain.product.adapter.in.web.dto;

import java.math.BigDecimal;

public record ProductUpdateRequest (
    String name,
    String description,
    BigDecimal price,
    int stock,
    String status,
    String modifierId
) {

}
