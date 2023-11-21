package com.example.demo.util.exceptions;

public class VehicleEntityNotFoundException extends RuntimeException{
    public VehicleEntityNotFoundException(String message) {
        super(message);
    }
}
