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

import com.example.rentcar.entities.FuelType;
import com.example.rentcar.services.FuelTypeService;

@RestController
@RequestMapping("/fueltypes")
public class FuelTypeController {
	
	@Autowired
	private FuelTypeService service;

	@GetMapping
	public ResponseEntity<List<FuelType>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FuelType> getFuelTypeById(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.getFuelTypeById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<FuelType> createFuelType(@RequestBody() FuelType fuelType) {
		return new ResponseEntity<>(service.createFuelType(fuelType), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FuelType> updateFuelType(@PathVariable("id") int id, 
			@RequestBody() FuelType fuelType) {
		
		return new ResponseEntity<>(service.updateFuelType(id, fuelType), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteFuelTypeById(@PathVariable("id") int id) {
		service.deleteFuelType(id);
	}
}
