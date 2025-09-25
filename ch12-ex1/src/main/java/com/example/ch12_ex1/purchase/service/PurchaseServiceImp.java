package com.example.ch12_ex1.purchase.service;

import com.example.ch12_ex1.purchase.domain.Purchase;
import com.example.ch12_ex1.purchase.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImp implements PurchaseService{
    private final PurchaseRepository purchaseRepository;

    // Repository DI
    public PurchaseServiceImp(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public List<Purchase> findAllPurchases() {
        return purchaseRepository.findAllPurchases();
    }

    @Override
    public void storePurchase(Purchase purchase) {
        purchaseRepository.storePurchase(purchase);
    }
}
