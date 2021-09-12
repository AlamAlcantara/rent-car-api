package com.example.rentcar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentcar.entities.WorkShift;

@Repository
public interface WorkShiftRepository extends JpaRepository<WorkShift, Integer> {

}
