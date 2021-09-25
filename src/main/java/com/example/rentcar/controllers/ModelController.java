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

import com.example.rentcar.entities.Model;
import com.example.rentcar.services.ModelService;

@RestController
@RequestMapping("/models")
@CrossOrigin(origins = "*")
public class ModelController {
	
	@Autowired
	private ModelService service;

	@GetMapping
	public ResponseEntity<List<Model>> getAll() {
		return new ResponseEntity<>(service.getModels(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Model> getModelById(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.getModelById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Model> createModel(@RequestBody() Model model) {
		return new ResponseEntity<>(service.createModel(model), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Model> updateModel(@PathVariable("id") int id, 
			@RequestBody() Model model) {
		
		return new ResponseEntity<>(service.updateModel(id, model), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteModelById(@PathVariable("id") int id) {
		service.deleteModel(id);
	}
}
