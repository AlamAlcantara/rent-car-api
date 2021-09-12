package com.example.rentcar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentcar.entities.CustomerType;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType, Integer> {

}
