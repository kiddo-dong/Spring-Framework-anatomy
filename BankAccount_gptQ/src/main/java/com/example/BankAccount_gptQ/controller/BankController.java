package com.example.BankAccount_gptQ.controller;

import com.example.BankAccount_gptQ.service.BankService;
import com.example.BankAccount_gptQ.service.InsufficientFundsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    /*
    @PostMapping("/bank")
    public ResponseEntity<String> withdraw(@RequestBody double amount){
        try{
            double result = bankService.withdraw(amount);

            return ResponseEntity
                    .ok("인출 완료: 남은 잔액 " + result + "원");

        } catch (InsufficientFundsException e){
            return ResponseEntity
                    .badRequest()
                    .body("잔액 부족");
        }
    }
    */

    @PostMapping("/bank")
    public ResponseEntity<String> withdraw(@RequestBody double amount){

        double result = bankService.withdraw(amount);
        return ResponseEntity
                .ok("인출 완료: 남은 잔액 " + result + "원");
    }
}
