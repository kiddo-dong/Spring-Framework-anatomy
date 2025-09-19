package com.example.ch11_ex1.proxy;

import com.example.ch11_ex1.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

// URL 하드코딩 x, 프로퍼티 파일에 설정
@FeignClient(name = "payments", url = "${name.server.url}")
public interface PaymentsProxy {

    @PostMapping("/payment")
    Payment createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    );
    // REST API 호출
}