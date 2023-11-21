package com.example.demo.model;

//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)

import com.example.demo.model.deserializer.VehicleDeserializer;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//@JsonDeserialize(using = VehicleDeserializer.class)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipo")
@JsonSubTypes({@JsonSubTypes.Type(value = Car.class, name = "COCHE"),
        @JsonSubTypes.Type(value = Motorcycle.class, name = "MOTO"),
        @JsonSubTypes.Type(value = Bicycle.class, name = "BICI")})
public interface Vehicle {
   // @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    int getId();
    String getVehicleType();
    void setVehicleType(String tipo);

    void setId(int id);

    static Vehicle valueOf(String tipo) {
        if ("coche".equalsIgnoreCase(tipo)) {
            return new Car();
        } else if ("moto".equalsIgnoreCase(tipo)) {
            return new Motorcycle();
        } else if ("bici".equalsIgnoreCase(tipo)) {
            return new Bicycle();
        } else {
            throw new IllegalArgumentException("Tipo de vehículo no válido: " + tipo);
        }
    }

}
