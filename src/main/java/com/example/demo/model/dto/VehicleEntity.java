package com.example.demo.model.dto;

import com.example.demo.model.Vehicle;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vehiculo")
@Data
public class VehicleEntity implements Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;
    String tipo;
    String matricula;
    String modelo_coche;
    String modelo_bici;
    int marchas;
    int caballosPotencia;

    public VehicleEntity() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo_coche() {
        return modelo_coche;
    }

    public void setModelo_coche(String modelo_coche) {
        this.modelo_coche = modelo_coche;
    }

    public String getModelo_bici() {
        return modelo_bici;
    }

    public void setModelo_bici(String modelo_bici) {
        this.modelo_bici = modelo_bici;
    }

    public int getMarchas() {
        return marchas;
    }

    public void setMarchas(int marchas) {
        this.marchas = marchas;
    }

    public int getCaballosPotencia() {
        return caballosPotencia;
    }

    public void setCaballosPotencia(int caballos_potencia) {
        this.caballosPotencia = caballos_potencia;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getVehicleType() {
        return this.tipo;
    }

    @Override
    public void setVehicleType(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
