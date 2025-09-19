package com.example.Order_RestException.exceptionAdvice;

import com.example.Order_RestException.exception.InsufficientFundsException;
import com.example.Order_RestException.exception.InvalidOrderAmountException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


// RestController Advice 로 DispatcherServlet의 HTTP의 에러 상태를 보고 메소드 호출 후 예외 처리
@RestControllerAdvice
public class OrderAdvice {
    
    @ExceptionHandler({InsufficientFundsException.class,InvalidOrderAmountException.class})
    public ResponseEntity<String> orderExceptionAdvice(){
        return ResponseEntity
                .badRequest()
                .body("잔액 검증 오류");
    }
    
    @ExceptionHandler()
}
