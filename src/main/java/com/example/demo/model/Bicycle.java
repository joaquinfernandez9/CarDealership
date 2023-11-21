package com.example.demo.model;

import com.example.demo.model.deserializer.VehicleDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("BICYCLE")
@Entity
//@DiscriminatorValue("BICI")
//@JsonDeserialize(using = VehicleDeserializer.class)
public class Bicycle implements Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String modelo;
    private Integer marchas;

    @Column(name = "tipo")
    private String tipo;


    @Override
    public int getId(){
        return this.id;
    }

    @Override
    public String getVehicleType() {
        return "BICI";
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

    public Bicycle() {
    }
}
