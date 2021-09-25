package com.example.rentcar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentcar.entities.CustomerType;
import com.example.rentcar.services.CustomerTypeService;

@RestController
@RequestMapping("/customer-types")
@CrossOrigin(origins = "*")
public class CustomerTypeController {
	
	@Autowired
	private CustomerTypeService service;
	
	@GetMapping
	public ResponseEntity<List<CustomerType>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerType> getCustomerTypeById(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.getCustomerTypeById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CustomerType> createCustomerType(
			@RequestBody() CustomerType customerType) {
		return new ResponseEntity<>(service.createCustomerType(customerType), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerType> updateCustomerType(@PathVariable("id") int id, 
			@RequestBody() CustomerType customerType) {
		
		return new ResponseEntity<>(service.updateCustomerType(id, customerType), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomerTypeById(@PathVariable("id") int id) {
		service.deleteCustomerType(id);
	}

}
