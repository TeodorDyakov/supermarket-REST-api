package com.example.supermarketapi.exception;

public class SupermarketNotFoundException extends RuntimeException {
    public SupermarketNotFoundException(String id) {
        super("Could not find supermarket with id  " + id);
    }
}
