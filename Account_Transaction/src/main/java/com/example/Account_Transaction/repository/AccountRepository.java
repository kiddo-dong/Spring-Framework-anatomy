package com.example.Account_Transaction.repository;

import com.example.Account_Transaction.domain.Account;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    void addAccount(Account account);
    void deleteAccountById(Long id);
    Account findAccountById(Long id);
    void UpdateTransferAmount(BigDecimal amount, Long id);
    List<Account> findAllAccount();
}