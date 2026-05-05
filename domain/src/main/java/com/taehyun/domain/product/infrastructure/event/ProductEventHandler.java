package com.taehyun.domain.product.infrastructure.event;

import com.taehyun.domain.product.application.event.ProductCreatedEvent;
import com.taehyun.domain.product.application.event.ProductDeletedEvent;
import com.taehyun.domain.product.application.event.ProductUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class ProductEventHandler {


    @Async
    @EventListener
    public void on(ProductCreatedEvent event) {
        log.info("Product Created Event: {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(ProductCreatedEvent event) {
        log.info("Product Created Event: {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(ProductUpdatedEvent event) {
        log.info("Product Updated Event: {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(ProductDeletedEvent event) {
        log.info("Product Deleted Event: {}", event);
    }
}
