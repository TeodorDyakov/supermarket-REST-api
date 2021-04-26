package com.example.supermarketapi.model;

import com.example.supermarketapi.model.enums.ItemType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@ToString
public class Item extends BaseEntity {

    @NotBlank(message = "name can not be blank")
    @Size(max = 64)
    private String name;
    @NotNull

    @DecimalMin(value = "0.01", message = "price cant be less than 0.01")
    @DecimalMax(value = "9999.99", message = "price cant be more than 9999.99")
    private Double price;
    @NotNull
    @Enumerated
    private ItemType type;

}
