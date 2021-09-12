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

import com.example.rentcar.entities.Customer;
import com.example.rentcar.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.getCustomerById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody() Customer customer) {
		return new ResponseEntity<>(service.createCustomer(customer), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, 
			@RequestBody() Customer customer) {
		
		return new ResponseEntity<>(service.updateCustomer(id, customer), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomerById(@PathVariable("id") int id) {
		service.deleteCustomer(id);
	}

}
