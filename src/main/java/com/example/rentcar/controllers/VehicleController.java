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

import com.example.rentcar.entities.Vehicle;
import com.example.rentcar.services.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleService service;
	
	@GetMapping
	public ResponseEntity<List<Vehicle>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.getVehicleById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Vehicle> createVehicle(@RequestBody() Vehicle vehicle) {
		return new ResponseEntity<>(service.createVehicle(vehicle), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") int id, 
			@RequestBody() Vehicle vehicle) {
		
		return new ResponseEntity<>(service.updateVehicle(id, vehicle), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteVehicleById(@PathVariable("id") int id) {
		service.deleteVehicle(id);
	}

}
