package com.example.rentcar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.rentcar.entities.Employee;
import com.example.rentcar.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	public List<Employee> getAll() {
		return repo.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Employee createEmployee(Employee employee) {
		return repo.save(employee);
	}
	
	public Employee updateEmployee(int id, Employee employee) { 
		Employee actualEmployee = this.getEmployeeById(id);
		
		actualEmployee.setName(employee.getName());
		actualEmployee.setCommissionPercentage(employee.getCommissionPercentage());
		actualEmployee.setEntryDate(employee.getEntryDate());
		actualEmployee.setPersonalId(employee.getPersonalId());
		actualEmployee.setWorkShift(employee.getWorkShift());
		actualEmployee.setActive(employee.isActive());
		
		return repo.save(actualEmployee);
	}
	
	public void deleteEmployee(int id) {
		repo.deleteById(id);
	}

}
