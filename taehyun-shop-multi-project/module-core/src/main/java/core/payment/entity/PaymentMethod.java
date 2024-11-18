package core.payment.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PaymentMethod {

    CARD("카드"),
    TRANSFER("이체"),
    CASH("현금");

    private final String description;
}
