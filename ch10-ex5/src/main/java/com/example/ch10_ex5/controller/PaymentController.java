package com.example.ch10_ex5.controller;

import com.example.ch10_ex5.service.PaymentDetails;
import com.example.ch10_ex5.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /*
    // 메소드 단계 에서의 예외 처리
    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(){
        
        // try-catch 문으로 메소드 단계에서의 예외처리
        try {
            // paymentDetails에서 예외 발생시 catch로 넘어감
            PaymentDetails paymentDetails = paymentService.processPayment();

            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);

        } catch(NotEnoughMoneyException e){
            // 잔액 부족시 에러 발생
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("잔액 부족");

            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);
            // 객체 없이 body("잔액 부족") 반환 해도 되지만
            // 유지보수를 위한 객체 리턴
        }
    }
        */

    // RestControllerAdvice로 Exception 가로채기
    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(){
        PaymentDetails paymentDetails = new PaymentDetails();

        // 예외 발생 시 ExceptionHandler에서 예외를 가로챔
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }

}