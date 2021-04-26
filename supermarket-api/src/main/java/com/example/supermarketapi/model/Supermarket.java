package com.example.supermarketapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Supermarket extends BaseEntity {

    @NotBlank(message = "name can not be blank")
    @Column(unique = true)
    @Size(max = 64)
    private String name;
    @NotBlank(message = "address not be blank")
    private String address;

    private String phoneNumber;

    private String workHours;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "supermarket_id")
    private Set<Item> items = new HashSet<>();

}
