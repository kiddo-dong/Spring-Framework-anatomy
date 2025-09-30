package com.example.Account_Transaction.controller;

import com.example.Account_Transaction.domain.Account;
import com.example.Account_Transaction.domain.TransferAmountDTO;
import com.example.Account_Transaction.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    // 계좌 생성
    @PostMapping
    public ResponseEntity<String> addAccount(@RequestBody Account account){
        accountService.addAccount(account);
        return ResponseEntity
                .ok("계좌가 생성되었습니다.");
    }

    // 계좌 조회
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Account>> findAccountById(@PathVariable Long id) {
        return ResponseEntity
                .ok(Optional.ofNullable(accountService.findAccountById(id)));
    }

    // 계좌 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteAccountById(@PathVariable Long id){
        accountService.deleteAccountById(id);
        return ResponseEntity
                .ok("계좌가 정상적으로 삭제되었습니다.");
    }

    // 송금 / 입금 트랜잭션
    @PostMapping("/remittance")
    public ResponseEntity<String> transferAmountTransaction(@RequestBody TransferAmountDTO transferAmountDTO){
        accountService.transferAmountTransaction(transferAmountDTO);
        return ResponseEntity
                .ok("송금 완료!");
    }

    // 전체 계좌 조회
    @GetMapping
    public ResponseEntity<List<Account>> findAllAccount(){
        return ResponseEntity
                .ok(accountService.findAllAccount());
    }
    
}
