package com.example.supermarketapi.controller;

import com.example.supermarketapi.exception.InvalidDataException;
import com.example.supermarketapi.model.Item;
import com.example.supermarketapi.model.enums.ItemType;
import com.example.supermarketapi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestParam String name, @RequestParam Double price, @RequestParam String type) {
        boolean anyMatches = Arrays.stream(ItemType.values()).anyMatch(typeOfItem -> type.equals(typeOfItem.name()));

        if(!anyMatches){
            throw new InvalidDataException("Invalid product type! Valid are FOOD, TECHNOLOGY, HOUSEHOLD, DRINKS");
        }

        ItemType itemType = ItemType.valueOf(type);
        Item item = new Item();
        item.setType(itemType);
        item.setPrice(price);
        item.setName(name);
        Item savedItem = itemService.createItem(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }
}
