package com.example.demo.service;

import com.example.demo.model.Vehicle;

import java.util.List;

public interface VehicleService {
    // create
    Vehicle save(Vehicle vehicle);

    // read
    List<Vehicle> findAll();

    Vehicle find(Integer id);

    // delete
    Vehicle delete(Vehicle v);

    void deleteByID(Integer v);
}
