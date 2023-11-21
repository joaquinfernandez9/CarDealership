package com.example.demo.service;

import com.example.demo.dao.repository.VehicleEntityRepository;
import com.example.demo.model.Vehicle;
import com.example.demo.model.mapper.VehicleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    VehicleEntityRepository repo;

    @Autowired
    public VehicleServiceImpl(VehicleEntityRepository repo) {
        this.repo = repo;
    }

    // create
    @Override
    public Vehicle save(Vehicle vehicle) {
        return repo.save(VehicleMapper.mapToVehicleEntity(vehicle));
    }

    // read
    @Override
    public List<Vehicle> findAll(){
        List<Vehicle> vehi =  repo.findAll().stream()
                .map(VehicleMapper::mapToVehicle)
                .toList();
        System.out.println("----");
        vehi.forEach(System.out::println);
        System.out.println("----");
        return vehi;
    }

    @Override
    public Vehicle find(Integer id){
        return repo.findById(id).orElse(null);
    }

    // update


    // delete
    @Override
    public Vehicle delete(Vehicle v){
        if (repo.findById(v.getId()).orElse(null)!= null){
            repo.delete(VehicleMapper.mapToVehicleEntity(v));
            return v;
        } else {
            return null;
        }
    }

    @Override
    public void deleteByID(Integer v){
        repo.deleteById(v);
    }

}
