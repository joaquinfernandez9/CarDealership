package com.example.demo.model.mapper;

import com.example.demo.model.Bicycle;
import com.example.demo.model.Car;
import com.example.demo.model.Motorcycle;
import com.example.demo.model.Vehicle;
import com.example.demo.model.dto.VehicleEntity;
import com.example.demo.util.exceptions.VehicleEntityNotFoundException;

public class VehicleMapper {
    public static Vehicle mapToVehicle(VehicleEntity vehicleEntity) {
        if (vehicleEntity == null) {
            throw new VehicleEntityNotFoundException("VehicleEntity is null");
        }

        if ("MOTO".equals(vehicleEntity.getTipo())) {
            Motorcycle motorcycle = new Motorcycle();
            mapCommonProperties(vehicleEntity, motorcycle);
            motorcycle.setCaballosPotencia(vehicleEntity.getCaballosPotencia());
            motorcycle.setMatricula(vehicleEntity.getMatricula());
            return motorcycle;
        } else if ("COCHE".equals(vehicleEntity.getTipo())) {
            Car car = new Car();
            mapCommonProperties(vehicleEntity, car);
            car.setModelo(vehicleEntity.getModelo_coche());
            car.setMatricula(vehicleEntity.getMatricula());
            return car;
        } else if ("BICI".equals(vehicleEntity.getTipo())) {
            Bicycle bicycle = new Bicycle();
            mapCommonProperties(vehicleEntity, bicycle);
            bicycle.setModelo(vehicleEntity.getModelo_bici());
            int marchas;
            try {
                marchas = vehicleEntity.getMarchas();
            } catch (NullPointerException e){
                marchas= 0;
                e.printStackTrace();
            }
            bicycle.setMarchas(marchas);
            return bicycle;
        } else {
            return null;
        }
    }

    public static VehicleEntity mapToVehicleEntity(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle is null");
        }

        VehicleEntity vehicleEntity = new VehicleEntity();
        mapCommonProperties(vehicle, vehicleEntity);

        if (vehicle instanceof Motorcycle motorcycle) {
            vehicleEntity.setCaballosPotencia(motorcycle.getCaballosPotencia());
            vehicleEntity.setMatricula(motorcycle.getMatricula());
        } else if (vehicle instanceof Car car) {
            vehicleEntity.setModelo_coche(car.getModelo());
            vehicleEntity.setMatricula(car.getMatricula());
        } else if (vehicle instanceof Bicycle bicycle) {
            vehicleEntity.setModelo_bici(bicycle.getModelo());
            vehicleEntity.setMarchas(bicycle.getMarchas());
        } else {
            throw new UnsupportedOperationException("Unsupported vehicle type: " + vehicle.getClass().getSimpleName());
        }

        return vehicleEntity;
    }

    private static void mapCommonProperties(Vehicle vehicle, VehicleEntity vehicleEntity) {
        vehicleEntity.setId(vehicle.getId());
        vehicleEntity.setTipo(vehicle.getVehicleType());
    }
    private static void mapCommonProperties(VehicleEntity vehicleEntity, Vehicle vehicle) {
        vehicle.setId(vehicleEntity.getId());
        vehicle.setVehicleType(vehicleEntity.getTipo());
    }
}
