package com.example.supermarketapi.service;

import com.example.supermarketapi.dto.AddItemsToSupermarketResponseDTO;
import com.example.supermarketapi.dto.SupermarketInfoDTO;
import com.example.supermarketapi.model.Supermarket;

import java.util.List;

public interface SupermarketService {

    Supermarket createSupermarket(Supermarket supermarket);

    AddItemsToSupermarketResponseDTO addItems(String supermarketId, List<String> itemIDs);

    SupermarketInfoDTO getSupermarketInfo(String id);
}
