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

import com.example.rentcar.entities.WorkShift;
import com.example.rentcar.services.WorkShiftService;

@RestController
@RequestMapping("/workshift")
public class WorkShiftController {
	
	@Autowired
	private WorkShiftService service;
	
	@GetMapping
	public ResponseEntity<List<WorkShift>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<WorkShift> getWorkShiftById(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.getWorkShiftById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<WorkShift> createWorkShift(@RequestBody() WorkShift workShift) {
		return new ResponseEntity<>(service.createWorkShift(workShift), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<WorkShift> updateWorkShift(@PathVariable("id") int id, 
			@RequestBody() WorkShift workShift) {
		
		return new ResponseEntity<>(service.updateWorkShift(id, workShift), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteWorkShiftById(@PathVariable("id") int id) {
		service.deleteWorkShift(id);
	}

}
