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

import com.example.rentcar.entities.VehicleType;
import com.example.rentcar.services.VehicleTypeService;

@RestController
@RequestMapping("/vehicles-types")
public class VehicleTypeController {
	
	@Autowired
	private VehicleTypeService service;
	
	@GetMapping
	public ResponseEntity<List<VehicleType>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VehicleType> getVehicleTypeById(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.getVehicleTypeById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<VehicleType> createVehicleType(
			@RequestBody() VehicleType vehicleType) {
		return new ResponseEntity<>(service.createVehicleType(vehicleType), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<VehicleType> updateVehicleType(@PathVariable("id") int id, 
			@RequestBody() VehicleType vehicleType) {
		
		return new ResponseEntity<>(service.updateVehicleType(id, vehicleType), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteVehicleTypeById(@PathVariable("id") int id) {
		service.deleteVehicleType(id);
	}

}
