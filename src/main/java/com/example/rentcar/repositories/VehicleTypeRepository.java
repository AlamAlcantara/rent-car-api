package com.example.rentcar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentcar.entities.VehicleType;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer>{

}
