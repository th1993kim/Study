package api.order.api;

import core.order.application.OrderService;
import core.order.application.OrderViewService;
import core.order.application.domain.OrderDetail;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;
    private final OrderViewService orderViewService;

    @PostMapping
    public ResponseEntity<Void> orderProduct(@RequestBody SaveOrderRequest request) {

        orderService.orderProduct(request.toSaveOrderCommand());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{seqOrderId}")
    public ResponseEntity<OrderDetail> getOrder(@PathVariable Long seqOrderId) {

        return ResponseEntity.ok(orderViewService.getOrderDetail(seqOrderId));
    }

}
