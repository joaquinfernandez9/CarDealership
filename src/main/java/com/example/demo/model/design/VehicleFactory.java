package com.example.demo.model.design;

import com.example.demo.model.Bicycle;
import com.example.demo.model.Car;
import com.example.demo.model.Motorcycle;
import com.example.demo.model.Vehicle;
import com.example.demo.model.enums.VehicleEnum;
import org.springframework.stereotype.Component;

@Component
public class VehicleFactory extends AbstractVehicleFactory {
    @Override
    public Vehicle getVehicleType(String vehicleType, Vehicle v) {
        switch (vehicleType){
            case "BICYCLE" -> {
                return new Bicycle();
            }
            case "CAR" -> {
                return new Car();
            }
            case "MOTORCYCLE" -> {
                return new Motorcycle();
            }
            default -> {
                throw new IllegalArgumentException("Tipo de vehículo no válido: " + vehicleType);
            }
        }
    }
}
