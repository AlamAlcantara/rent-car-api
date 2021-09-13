package com.example.rentcar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentcar.entities.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {

}
