package com.example.Account_Transaction.service;

import com.example.Account_Transaction.domain.Account;
import com.example.Account_Transaction.domain.TransferAmountDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountService {
    void addAccount(Account account);
    void deleteAccountById(Long id);
    Account findAccountById(Long id);
    void transferAmountTransaction(TransferAmountDTO transferAmountDTO);
    List<Account> findAllAccount();
}
