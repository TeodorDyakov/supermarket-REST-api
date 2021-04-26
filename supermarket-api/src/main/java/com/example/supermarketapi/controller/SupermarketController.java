package com.example.supermarketapi.controller;

import com.example.supermarketapi.dto.AddItemsToSupermarketResponseDTO;
import com.example.supermarketapi.dto.SupermarketInfoDTO;
import com.example.supermarketapi.exception.InvalidDataException;
import com.example.supermarketapi.model.Supermarket;
import com.example.supermarketapi.service.SupermarketService;
import com.example.supermarketapi.validation.WorkingTimeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/supermarkets")
public class SupermarketController {
    private final SupermarketService supermarketService;

    @Autowired
    public SupermarketController(SupermarketService supermarketService) {
        this.supermarketService = supermarketService;
    }

    @PostMapping
    public ResponseEntity<Supermarket> createSupermarket(@RequestParam String name, @RequestParam String address,
                                                         @RequestParam String phoneNumber, @RequestParam String workingHours) {
        if(address.length() > 128){
            throw new InvalidDataException("Address exceeds max length of 128!");
        }

        if(name.length() > 64){
            throw new InvalidDataException("Name exceeds max length of 64!");
        }

        if(!phoneNumber.matches("08[7-9][0-9]{7}")){
            throw new InvalidDataException("phone number is invalid!");
        }

        if(!WorkingTimeValidator.isValid(workingHours)){
            throw new InvalidDataException("working hours are invalid!");
        }

        Supermarket supermarket = new Supermarket();
        supermarket.setName(name);
        supermarket.setAddress(address);
        supermarket.setPhoneNumber(phoneNumber);
        supermarket.setWorkHours(workingHours);

        Supermarket savedSupermarket = supermarketService.createSupermarket(supermarket);
        return new ResponseEntity<>(savedSupermarket, HttpStatus.CREATED);
    }

    @PostMapping("/addItems")
    public ResponseEntity<AddItemsToSupermarketResponseDTO> addItemToSupermarket(@RequestParam @NotNull String
                                                                                         supermarketId,
                                                                                 @RequestParam @NotEmpty
                                                                                         List<String> itemsIDs) {
        AddItemsToSupermarketResponseDTO addItemsToSupermarketResponseDTO =
                supermarketService.addItems(supermarketId, itemsIDs);
        return new ResponseEntity<>(addItemsToSupermarketResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/{supermarketId}")
    public ResponseEntity<SupermarketInfoDTO> getSupermarket(@PathVariable String supermarketId) {
        return new ResponseEntity<>(supermarketService.getSupermarketInfo(supermarketId), HttpStatus.OK);
    }

}
