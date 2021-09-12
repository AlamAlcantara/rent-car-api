package com.example.rentcar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentcar.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
