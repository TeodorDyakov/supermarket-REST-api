package com.example.supermarketapi.validation;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class WorkingTimeValidator {

    public static boolean isValid(String workingTime){
        //faster performance
        if(workingTime.length() != 11){
            return false;
        }
        String[] parts = workingTime.split("-");
        try {
            LocalTime.parse(parts[0]);
            LocalTime.parse(parts[1]);
        } catch (DateTimeParseException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
