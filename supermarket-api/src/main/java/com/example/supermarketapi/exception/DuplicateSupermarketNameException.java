package com.example.supermarketapi.exception;

public class DuplicateSupermarketNameException extends RuntimeException {
    public DuplicateSupermarketNameException(String s) {
        super(s);
    }
}
