package com.taehyun.domain.product.application.event;

import java.util.UUID;

public record ProductCreatedEvent(
        UUID productId,
        UUID actorId
) {
}
