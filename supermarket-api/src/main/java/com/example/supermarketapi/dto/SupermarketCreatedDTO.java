package com.example.supermarketapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SupermarketCreatedDTO {
    private String name;
    private String address;
    private String phoneNumber;
    private String workHours;
    private List<String> items;
}
