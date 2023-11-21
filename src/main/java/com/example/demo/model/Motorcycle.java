package com.example.demo.model;

import com.example.demo.model.deserializer.VehicleDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "motorcycle")
@Data
//@DiscriminatorValue("MOTO")
//@JsonDeserialize(using = VehicleDeserializer.class)
public class Motorcycle implements Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int caballosPotencia;
    private String matricula;
    @Column(name = "tipo")
    private String tipo;

    public Motorcycle(int caballosPotencia, String matricula, String tipo) {
        this.caballosPotencia = caballosPotencia;
        this.matricula = matricula;
        this.tipo = tipo;
    }
    @Override
    public int getId(){
        return this.id;
    }
    @Override
    public String getVehicleType() {
        return "MOTO";
    }

    public Motorcycle() {
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

    public int getCaballosPotencia() {
        return caballosPotencia;
    }

    public void setCaballosPotencia(int caballosPotencia) {
        this.caballosPotencia = caballosPotencia;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String licensePlate) {
        this.matricula = licensePlate;
    }

}
