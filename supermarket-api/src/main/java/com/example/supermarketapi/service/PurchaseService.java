package com.example.supermarketapi.service;

import com.example.supermarketapi.model.Purchase;
import com.example.supermarketapi.model.enums.PaymentType;

import java.util.List;

public interface PurchaseService {
    public Purchase makePurchase(String supermarketId, List<String> itemIDs, PaymentType type, Double cashAmount);

    public List<Purchase> getAll();
}
