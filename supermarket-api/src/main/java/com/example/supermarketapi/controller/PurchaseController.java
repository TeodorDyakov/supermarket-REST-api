package com.example.supermarketapi.controller;

import com.example.supermarketapi.dto.PurchaseDTO;
import com.example.supermarketapi.exception.InvalidDataException;
import com.example.supermarketapi.model.Purchase;
import com.example.supermarketapi.model.enums.PaymentType;
import com.example.supermarketapi.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/purchases")
public class PurchaseController {

    PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<PurchaseDTO> buyItemsFromSupermarket(@RequestParam String supermarketId, @RequestParam List<String> itemIDs,
                                                               @RequestParam String type,
                                                               @RequestParam(required = false) Double cashAmount) {
        if(!type.equals("CASH") && !type.equals("CARD")){
            throw new InvalidDataException("invalid type of payment! Valid are CARD and CASH");
        }
        PaymentType paymentType = PaymentType.valueOf(type);
        if (paymentType == PaymentType.CASH && cashAmount == null) {
            throw new InvalidDataException("cash amount can not be null when you pay with cash!");
        }
        Purchase purchase = purchaseService.makePurchase(supermarketId, itemIDs, paymentType, cashAmount);
        PurchaseDTO purchaseDTO = new PurchaseDTO(purchase.getPrice(), purchase.getChangeAmount(), purchase.getTimeOfPayment());
        return new ResponseEntity<>(purchaseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseDTO>> getAll() {
        List<PurchaseDTO> response = purchaseService.getAll().stream().
                map(purchase -> new PurchaseDTO(purchase.getPrice(), purchase.getChangeAmount(),
                        purchase.getTimeOfPayment())).collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
