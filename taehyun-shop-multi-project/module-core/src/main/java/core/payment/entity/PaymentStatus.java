package core.payment.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PaymentStatus {

    REQUEST("결제 요청중"),
    PROGRESS("결제 진행중"),
    COMPLETE("결제 완료"),
    CANCELED("결제 취소"),
    FAILED("결제 실패"),
    REFUNDED("환불");

    private final String description;
}
