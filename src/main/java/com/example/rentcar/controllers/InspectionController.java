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

import com.example.rentcar.entities.Inspection;
import com.example.rentcar.services.InspectionService;

@RestController
@RequestMapping("/inspections")
public class InspectionController {
	
	@Autowired
	private InspectionService service;
	
	@GetMapping
	public ResponseEntity<List<Inspection>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Inspection> getInspectionById(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.getInspectionById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Inspection> createInspection(@RequestBody() Inspection inspection) {
		return new ResponseEntity<>(service.createInspection(inspection), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Inspection> updateInspection(@PathVariable("id") int id, 
			@RequestBody() Inspection inspection) {
		
		return new ResponseEntity<>(service.updateInspection(id, inspection), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteInspectionById(@PathVariable("id") int id) {
		service.deleteInspection(id);
	}

}
