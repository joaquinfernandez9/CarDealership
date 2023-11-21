package com.example.demo.dao.repository;

import com.example.demo.model.dto.VehicleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleEntityRepository extends VehicleRepository<VehicleEntity>{

}
