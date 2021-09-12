package com.example.rentcar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.rentcar.entities.VehicleType;
import com.example.rentcar.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {
	
	@Autowired
	private VehicleTypeRepository repo;
	
	public List<VehicleType> getAll() {
		return repo.findAll();
	}
	
	public VehicleType getVehicleTypeById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public VehicleType createVehicleType(VehicleType vehicleType) {
		return repo.save(vehicleType);
	}
	
	public VehicleType updateVehicleType(int id, VehicleType vehicleType) { 
		VehicleType actualVehicleType = this.getVehicleTypeById(id);
		
		actualVehicleType.setDescription(vehicleType.getDescription());
		actualVehicleType.setActive(vehicleType.isActive());
		
		return repo.save(actualVehicleType);
	}
	
	public void deleteVehicleType(int id) {
		repo.deleteById(id);
	}

}
