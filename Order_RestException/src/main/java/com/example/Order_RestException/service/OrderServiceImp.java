package com.example.Order_RestException.service;

import com.example.Order_RestException.domain.User;
import com.example.Order_RestException.exception.InsufficientFundsException;
import com.example.Order_RestException.exception.InvalidOrderAmountException;

public class OrderServiceImp implements OrderService{
    private User user;

    @Override
    public double order(double amount) {
        if(user.getAmount()<amount){
            throw new InsufficientFundsException();
        } else if (amount <= 0) {
            throw new InvalidOrderAmountException();
        } else {
            user.setAmount(user.getAmount() - amount);
            return user.getAmount();
        }
    }
}
