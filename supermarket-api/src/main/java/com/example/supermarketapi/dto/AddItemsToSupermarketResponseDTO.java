package com.example.supermarketapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddItemsToSupermarketResponseDTO {

    public AddItemsToSupermarketResponseDTO(String supermarketId, List<String> addedItemsNames) {
        this.supermarketId = supermarketId;
        this.addedItemsNames = addedItemsNames;
    }

    private String supermarketId;
    private List<String> addedItemsNames;

}
