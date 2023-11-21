package com.example.demo.dao.repository;

import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface VehicleRepository<V extends Vehicle> extends JpaRepository<V, Integer> {}
