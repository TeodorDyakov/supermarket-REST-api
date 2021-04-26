package com.example.supermarketapi.dto;

import com.example.supermarketapi.model.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SupermarketInfoDTO {

    private String name;
    private String address;
    private String phoneNumber;
    private String workHours;
    private List<Item> items;
}
