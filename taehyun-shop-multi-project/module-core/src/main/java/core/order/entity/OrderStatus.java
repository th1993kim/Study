package core.order.entity;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum OrderStatus {

    REQUEST("주문 요청중"),
    PROGRESS("주문 진행중"),
    COMPLETE("주문 완료"),
    CANCEL("주문 취소");

    private final String description;
}
