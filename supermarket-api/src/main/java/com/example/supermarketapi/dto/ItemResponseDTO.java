package com.example.supermarketapi.dto;

import com.example.supermarketapi.model.ItemType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponseDTO {

    private String name;
    private Double price;
    private ItemType type;

}
