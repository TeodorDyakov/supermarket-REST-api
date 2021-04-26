package com.example.supermarketapi.repository;

import com.example.supermarketapi.model.Supermarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupermarketRepository extends JpaRepository<Supermarket, String> {
    Optional<Supermarket> findSupermarketByName(String name);
}
