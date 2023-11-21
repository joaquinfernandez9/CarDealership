package com.example.demo.model;

import com.example.demo.model.deserializer.VehicleDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("CAR")
@Entity
//@DiscriminatorValue("COCHE")
//@JsonDeserialize(using = VehicleDeserializer.class)
public class Car implements Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String modelo;
    private String matricula;
    @Column(name = "tipo")
    private String tipo;

    @Override
    public int getId(){
        return this.id;
    }

    @Override
    public String getVehicleType() {
        return "COCHE";
    }

    @Override
    public void setVehicleType(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void setId(int id) {
        try {
            this.id = Math.toIntExact(id);
        } catch (NullPointerException e){
            this.id = 0;
            e.printStackTrace();
        }
    }

    public Car() {
    }
}
