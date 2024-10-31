package core.order.api;

import core.order.api.request.SaveOrderRequest;
import core.order.application.OrderService;
import core.order.application.OrderViewService;
import core.order.application.domain.OrderDetail;
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
    public ResponseEntity<Void> saveOrder(@RequestBody SaveOrderRequest request) {

        orderService.saveOrder(request.toSaveOrderCommand());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{seqOrderId}")
    public ResponseEntity<OrderDetail> getOrder(@PathVariable Long seqOrderId) {

        return ResponseEntity.ok(orderViewService.getOrderDetail(seqOrderId));
    }

    @GetMapping("/{seqOrderId}/slowly")
    public ResponseEntity<OrderDetail> findOrderSlowly(@PathVariable Long seqOrderId) {

        return ResponseEntity.ok(orderViewService.findOrderSlowly(seqOrderId));
    }
}
