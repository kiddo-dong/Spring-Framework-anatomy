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
        orderService.order(amount);
        return ResponseEntity
                .ok("구매완료");
    }
}
