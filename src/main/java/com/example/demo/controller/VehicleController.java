package com.example.demo.controller;

import com.example.demo.model.Bicycle;
import com.example.demo.model.Car;
import com.example.demo.model.Motorcycle;
import com.example.demo.model.Vehicle;

import com.example.demo.model.dto.VehicleEntity;
import com.example.demo.model.mapper.VehicleMapper;
import com.example.demo.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller("Vehiculo controller")
@RestController
@RequestMapping("/vehicles")
@Validated
public class VehicleController {

    @Autowired
    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Vehicle>> getAll() {
        List<Vehicle> vehicles = service.findAll();
        if (vehicles.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable Integer id){
        Vehicle vehicle = service.find(id);
        if (vehicle != null){
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Vehicle vehicle) {
        System.out.println("------ Vehiculo a insertar: " + vehicle);

        Vehicle v = service.save(vehicle);
        System.out.println("------ ID: " +v.getId());
        //return new ResponseEntity<>(v, HttpStatus.CREATED);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(v.getId())
                .toUri();
        return ResponseEntity.created(location).body(v);
    }

    @DeleteMapping
    public ResponseEntity<Vehicle> delete(@RequestBody Vehicle vehicle){
        Vehicle v = service.delete(vehicle);
        if (v != null){
            return new ResponseEntity<>(v, HttpStatus.I_AM_A_TEAPOT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Vehicle> deleteByID(@PathVariable Integer id){
        service.deleteByID(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
















}
