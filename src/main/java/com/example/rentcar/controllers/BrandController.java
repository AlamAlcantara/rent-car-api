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

import com.example.rentcar.entities.Brand;
import com.example.rentcar.entities.Model;
import com.example.rentcar.services.BrandService;

@RestController
@RequestMapping("/brands")
@CrossOrigin(origins = "*")
public class BrandController {
	
	@Autowired
	private BrandService service;
	
	@GetMapping
	public ResponseEntity<List<Brand>> getAll() {
		return new ResponseEntity<>(service.getBrands(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Brand> getBrandById(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.getBrandById(id), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/models")
	public ResponseEntity<List<Model>> getBrandModels(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.getBrandModels(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Brand> createBrand(@RequestBody() Brand brand) {
		return new ResponseEntity<>(service.createBrand(brand), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Brand> updateBrand(@PathVariable("id") int id, 
			@RequestBody() Brand brand) {
		
		return new ResponseEntity<>(service.updateBrand(id, brand), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBrandById(@PathVariable("id") int id) {
		service.deleteBrand(id);
	}

}
