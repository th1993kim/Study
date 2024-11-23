package api.order.api;

import api.order.api.request.CompleteOrderRequest;
import api.order.api.request.SaveOrderRequest;
import core.order.application.OrderService;
import core.order.application.OrderViewService;
import core.order.application.domain.OrderCompleteResult;
import core.order.application.domain.OrderDetail;
import core.order.application.domain.OrderProductResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;
    private final OrderViewService orderViewService;

    @PostMapping
    public ResponseEntity<OrderProductResult> orderProduct(@RequestBody SaveOrderRequest request) {
        return ResponseEntity.ok(orderService.orderProduct(request.toSaveOrderCommand()));
    }

    @GetMapping("/{seqOrderId}")
    public ResponseEntity<OrderDetail> getOrder(@PathVariable Long seqOrderId) {
        return ResponseEntity.ok(orderViewService.getOrderDetail(seqOrderId));
    }

    @PostMapping("/complete")
    public ResponseEntity<OrderCompleteResult> complete(@RequestBody CompleteOrderRequest request) {
        return ResponseEntity.ok(orderService.orderComplete(request.toCompleteOrderCommand()));
    }

}
