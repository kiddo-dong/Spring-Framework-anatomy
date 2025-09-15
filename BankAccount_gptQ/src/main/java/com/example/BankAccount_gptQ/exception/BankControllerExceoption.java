package com.example.BankAccount_gptQ.exception;

import com.example.BankAccount_gptQ.service.InsufficientFundsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BankControllerExceoption {

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<String> exceptionBankCon(){
        return ResponseEntity
                .badRequest()
                .body("잔액 부족");
    }
}