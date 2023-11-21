package com.example.demo.model.design;

import com.example.demo.model.Vehicle;
import com.example.demo.model.enums.VehicleEnum;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractVehicleFactory {
    public abstract Vehicle getVehicleType(String vehicle, Vehicle v);
}
