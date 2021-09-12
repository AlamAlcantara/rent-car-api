package com.example.rentcar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentcar.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
