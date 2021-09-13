package com.example.rentcar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.rentcar.entities.Vehicle;
import com.example.rentcar.repositories.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository repo;
	
	public List<Vehicle> getAll() {
		return repo.findAll();
	}
	
	public Vehicle getVehicleById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Vehicle createVehicle(Vehicle vehicle) {
		return repo.save(vehicle);
	}
	
	public Vehicle updateVehicle(int id, Vehicle vehicle) { 
		Vehicle actualVehicle = this.getVehicleById(id);
		
		actualVehicle.setState(vehicle.getState());
		actualVehicle.setBrand(vehicle.getBrand());
		actualVehicle.setModel(vehicle.getModel());
		actualVehicle.setFuelType(vehicle.getFuelType());
		actualVehicle.setImageUrl(vehicle.getImageUrl());
		actualVehicle.setDescription(vehicle.getDescription());
		actualVehicle.setVehicleType(vehicle.getVehicleType());
		actualVehicle.setEngineNumber(vehicle.getEngineNumber());
		actualVehicle.setLicensePlate(vehicle.getLicensePlate());
		actualVehicle.setChassisNumber(vehicle.getChassisNumber());
		
		return repo.save(actualVehicle);
	}
	
	public void deleteVehicle(int id) {
		repo.deleteById(id);
	}

}
