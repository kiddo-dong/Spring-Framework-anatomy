package com.example.ch12_ex1.purchase.repository;

import com.example.ch12_ex1.purchase.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    public void storePurchase(Purchase purchase);
    public List<Purchase> findAllPurchases();
}
