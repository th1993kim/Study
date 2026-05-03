package com.taehyun.domain.product.presentation.dto.request;

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
