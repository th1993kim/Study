package com.taehyun.domain.product.application.event;

import java.util.UUID;

public record ProductDeletedEvent(
        UUID productId,
        UUID actorId
) {
}
