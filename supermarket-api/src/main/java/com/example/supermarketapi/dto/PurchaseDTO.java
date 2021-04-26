package com.example.supermarketapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class PurchaseDTO {
    @NotNull
    private Double price;
    private Double change;
    @NotNull
    private LocalDate timeOfPayment;
}
