package com.example.BankAccount_gptQ.service;

import com.example.BankAccount_gptQ.domain.BankAccount;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImp implements BankService{

    private BankAccount bankAccount;

    @Override
    public double withdraw(double amount){
        if(bankAccount.getBalance() > amount){
           bankAccount.setBalance(bankAccount.getBalance()-amount);
           return bankAccount.getBalance();
        } else {
            throw new InsufficientFundsException();
        }
    }
}
