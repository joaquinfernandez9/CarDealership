package com.example.demo.model.deserializer;

import com.example.demo.model.Bicycle;
import com.example.demo.model.Car;
import com.example.demo.model.Motorcycle;
import com.example.demo.model.Vehicle;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class VehicleDeserializer extends StdDeserializer<Vehicle> {

    public VehicleDeserializer() {
        this(Vehicle.class);
    }

    public VehicleDeserializer(Class<?> vc) {
        super(vc);
    }

//    @Override
//    public Vehicle deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
//        JsonNode node = p.getCodec().readTree(p);
//        String tipo = node.get("tipo").asText();
//
//        if ("coche".equalsIgnoreCase(tipo)) {
//            //return p.getCodec().treeToValue(node, Car.class);
//            return ctxt.readValue(node.traverse(p.getCodec()), Car.class);
//        } else if ("moto".equalsIgnoreCase(tipo)) {
//            //return p.getCodec().treeToValue(node, Motorcycle.class);
//            return ctxt.readValue(node.traverse(p.getCodec()), Motorcycle.class);
//        } else if ("bici".equalsIgnoreCase(tipo)){
//            //return p.getCodec().treeToValue(node, Bicycle.class);
//            return ctxt.readValue(node.traverse(p.getCodec()), Bicycle.class);
//        } else {
//            throw new IOException("Tipo de vehículo no válido: " + tipo);
//        }
//    }

    @Override
    public Vehicle deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        String tipo = node.get("tipo").asText();
        // Utiliza el método estático valueOf en la interfaz Vehicle
        return Vehicle.valueOf(tipo);
    }

}
