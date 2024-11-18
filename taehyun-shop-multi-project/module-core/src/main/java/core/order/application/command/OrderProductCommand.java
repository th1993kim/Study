package core.order.application.command;

import lombok.Builder;

@Builder
public record OrderProductCommand(
        long seqProduct,
        int price,
        long regId,
        long updateId
) {
}
