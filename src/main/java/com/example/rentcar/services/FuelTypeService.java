package com.example.rentcar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.rentcar.entities.FuelType;
import com.example.rentcar.repositories.FuelTypeRepository;

@Service
public class FuelTypeService {

	@Autowired
	private FuelTypeRepository repo;
	
	public List<FuelType> getAll() {
		return repo.findAll();
	}
	
	public FuelType getFuelTypeById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public FuelType createFuelType(FuelType fuelType) {
		return repo.save(fuelType);
	}
	
	public FuelType updateFuelType(int id, FuelType fuelType) { 
		FuelType actualFuelType = this.getFuelTypeById(id);
		
		actualFuelType.setDescription(fuelType.getDescription());
		actualFuelType.setActive(fuelType.isActive());
		
		return repo.save(actualFuelType);
	}
	
	public void deleteFuelType(int id) {
		repo.deleteById(id);
	}
}
