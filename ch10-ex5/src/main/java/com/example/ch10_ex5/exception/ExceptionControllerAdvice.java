package com.example.ch10_ex5.exception;

import com.example.ch10_ex5.service.ErrorDetails;
import com.example.ch10_ex5.service.NotEnoughMoneyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler(){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("잔액 부족");

        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
