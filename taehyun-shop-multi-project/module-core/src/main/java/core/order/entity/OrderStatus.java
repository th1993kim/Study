package core.order.entity;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum OrderStatus {

    REQUEST("결제 요청중"),
    PROGRESS("결제 진행중"),
    COMPLETE("결제 완료"),
    CANCEL("결제 취소");

    private final String description;
}
