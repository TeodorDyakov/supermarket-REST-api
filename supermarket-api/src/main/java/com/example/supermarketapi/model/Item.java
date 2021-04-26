package com.example.supermarketapi.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@ToString
public class Item extends BaseEntity {

    @NotBlank(message = "name can not be blank")
    private String name;
    @NotNull
    private Double price;
    @NotNull
    @Enumerated
    private ItemType type;

//    @ManyToOne(optional = true, fetch = FetchType.LAZY)
//    private Supermarket supermarket;
}
