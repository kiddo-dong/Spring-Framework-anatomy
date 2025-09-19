package com.example.Order_RestException.controller;

import com.example.Order_RestException.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<String> order(@RequestBody double amount){

        //RestControllerAdvice 예외처리로 따로 예외 지정 X (우선 순위 메소드 -> Advice)
        orderService.order(amount);
        return ResponseEntity
                .ok("구매완료");
    }
}
