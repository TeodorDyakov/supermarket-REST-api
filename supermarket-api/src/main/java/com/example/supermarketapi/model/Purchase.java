package com.example.supermarketapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Purchase extends BaseEntity {

    @NotNull
    private Double price;
    @NotNull
    private Double changeAmount;
    @NotNull
    private LocalDate timeOfPayment;
}
