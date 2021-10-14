package com.example.rentcar.controllers;

import java.io.IOException;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.server.ResponseStatusException;

import com.example.rentcar.entities.Inspection;
import com.example.rentcar.entities.Rent;
import com.example.rentcar.services.RentService;
import com.example.rentcar.services.ReportService;

@RestController
@RequestMapping("/rents")
@CrossOrigin(origins = "*")
public class RentController {
	
	@Autowired
	private RentService service;
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping
	public ResponseEntity<List<Rent>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Rent> getRentById(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.getRentById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Rent> createRent(@RequestBody() Rent rent) {
		return new ResponseEntity<>(service.createRent(rent), HttpStatus.CREATED);
	}
	
	@PostMapping("/complete-rent/{id}")
	public ResponseEntity<Void> completeRent(@PathVariable("id") int rentId, 
			@RequestBody() Inspection inspection) {
		service.completeRent(rentId, inspection);
		
		return new ResponseEntity<>(HttpStatus.OK);
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
	
	@GetMapping("/report")
	public ResponseEntity<Resource> getRepor() {
		
		try {
			Resource resource = reportService.generateReport();
			String mimeType = new MimetypesFileTypeMap().getContentType(resource.getFile());
			
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType(mimeType))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ resource.getFilename()+"\"")
					.body(resource);
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ha ocurrido un error generando el reporte");
		}
	}
	
	
	

}
