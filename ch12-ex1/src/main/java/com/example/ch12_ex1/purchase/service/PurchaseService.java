package com.example.ch12_ex1.purchase.service;

import com.example.ch12_ex1.purchase.domain.Purchase;

import java.util.List;

public interface PurchaseService {
    public void storePurchase(Purchase purchase);
    public List<Purchase> findAllPurchases();
}
