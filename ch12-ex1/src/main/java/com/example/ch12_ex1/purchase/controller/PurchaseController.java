package com.example.ch12_ex1.purchase.controller;

import com.example.ch12_ex1.purchase.domain.Purchase;
import com.example.ch12_ex1.purchase.service.PurchaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;

    // Service DI
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public void storePurchase(@RequestBody  Purchase purchase){
        purchaseService.storePurchase(purchase);
    }

    @GetMapping
    public List<Purchase> findAllPurchases(){
        return purchaseService.findAllPurchases();
    }

}