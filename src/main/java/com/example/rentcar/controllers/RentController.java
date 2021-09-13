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

import com.example.rentcar.entities.Rent;
import com.example.rentcar.services.RentService;

@RestController
@RequestMapping("/rents")
public class RentController {
	
	@Autowired
	private RentService service;
	
	@GetMapping
	public ResponseEntity<List<Rent>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Rent> getModelById(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.getRentById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Rent> createModel(@RequestBody() Rent rent) {
		return new ResponseEntity<>(service.createRent(rent), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Rent> updateRent(@PathVariable("id") int id, 
			@RequestBody() Rent rent) {
		
		return new ResponseEntity<>(service.updateRent(id, rent), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRentById(@PathVariable("id") int id) {
		service.deleteRent(id);
	}

}
