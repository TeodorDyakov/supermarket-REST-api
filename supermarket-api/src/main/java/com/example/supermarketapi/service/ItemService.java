package com.example.supermarketapi.service;

import com.example.supermarketapi.model.Item;
import org.springframework.stereotype.Service;

public interface ItemService {

    public Item createItem(Item item);
}
