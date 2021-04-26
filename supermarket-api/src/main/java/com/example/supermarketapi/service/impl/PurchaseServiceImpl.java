package com.example.supermarketapi.service.impl;

import com.example.supermarketapi.dto.SupermarketInfoDTO;
import com.example.supermarketapi.model.Item;
import com.example.supermarketapi.model.PaymentType;
import com.example.supermarketapi.model.Purchase;
import com.example.supermarketapi.repository.PurchaseRepository;
import com.example.supermarketapi.service.PurchaseService;
import com.example.supermarketapi.service.SupermarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private SupermarketService supermarketService;
    private PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(SupermarketService supermarketService, PurchaseRepository purchaseRepository){
        this.supermarketService = supermarketService;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Purchase makePurchase(String supermarketId, List<String> itemIDs, PaymentType type, Double cashAmount) {
        SupermarketInfoDTO supermarketInfoDTO = supermarketService.getSupermarketInfo(supermarketId);
        double price = 0.0;

        for(String id : itemIDs){
            for(Item item : supermarketInfoDTO.getItems()){
                if(id.equals(item.getId())){
                    price += item.getPrice();
                }
            }
        }
        double change = 0;
        if(type == PaymentType.CASH) {
            change = cashAmount - price;
        }
        Purchase purchase = new Purchase();
        purchase.setChangeAmount(change);
        purchase.setPrice(price);
        purchase.setTimeOfPayment(LocalDate.now());
        return purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> getAll() {
        return purchaseRepository.findAll();
    }
}
