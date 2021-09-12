package com.example.rentcar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentcar.entities.Employee;
import com.example.rentcar.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getBrandById(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.getEmployeeById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody() Employee employee) {
		return new ResponseEntity<>(service.createEmployee(employee), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateModel(@PathVariable("id") int id, 
			@RequestBody() Employee employee) {
		
		return new ResponseEntity<>(service.updateEmployee(id, employee), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployeeById(@PathVariable("id") int id) {
		service.deleteEmployee(id);
	}
}
