package com.example.rentcar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.rentcar.entities.Inspection;
import com.example.rentcar.entities.Rent;
import com.example.rentcar.entities.Vehicle;
import com.example.rentcar.enums.RentState;
import com.example.rentcar.enums.VehicleState;
import com.example.rentcar.repositories.RentRepository;

@Service
public class RentService {
	
	@Autowired
	private RentRepository repo;
	
	@Autowired
	private InspectionService inspectionService;
	
	@Autowired
	private VehicleService vehicleService;
	
	public List<Rent> getAll() {
		return repo.findAll();
	}
	
	public Rent getRentById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Rent createRent(Rent rent) {
		
		Rent savedRent = repo.save(rent);
		
		Vehicle vehicle = rent.getVehicle();
		vehicle.setState(VehicleState.RENTED);
		vehicleService.updateVehicle(vehicle.getId(), vehicle);
		
		for(Inspection i: rent.getInspections() ) {
			i.setRent(savedRent);
			inspectionService.createInspection(i);
		}
		
		return savedRent;
	}
	
	public Rent updateRent(int id, Rent rent) { 
		Rent actualRent = this.getRentById(id);
		
		actualRent.setAmountPerDay(rent.getAmountPerDay());
		actualRent.setComment(rent.getComment());
		actualRent.setCustomer(rent.getCustomer());
		actualRent.setEmployee(rent.getEmployee());
		actualRent.setStartDate(rent.getStartDate());
		actualRent.setEndDate(rent.getEndDate());
		actualRent.setVehicle(rent.getVehicle());
		actualRent.setState(rent.getState());
		
		return repo.save(actualRent);
	}
	
	
	public void completeRent(int rentId, Inspection inspection) {
		//Updating rent
		Rent actualRent = this.getRentById(rentId);
		actualRent.setState(RentState.COMPLETED);
		repo.save(actualRent);
		
		//Creating inspection
		inspection.setRent(actualRent);
		inspectionService.createInspection(inspection);
		
		//Updating vehicle state
		Vehicle vehicle = inspection.getVehicle();
		vehicle.setState(VehicleState.AVAILABLE);
		vehicleService.updateVehicle(vehicle.getId(), vehicle);
	
	}
	
	public void deleteRent(int id) {
		repo.deleteById(id);
	}

}
