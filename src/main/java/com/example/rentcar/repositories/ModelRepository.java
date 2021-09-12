package com.example.rentcar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentcar.entities.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {

}
