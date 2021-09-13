package com.example.rentcar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.rentcar.entities.Inspection;
import com.example.rentcar.repositories.InspectionRepository;

@Service
public class InspectionService {
	
	@Autowired
	private InspectionRepository repo;
	
	public List<Inspection> getAll() {
		return repo.findAll();
	}
	
	public Inspection getInspectionById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Inspection createInspection(Inspection inspection) {
		return repo.save(inspection);
	}
	
	public Inspection updateInspection(int id, Inspection inspection) { 
		Inspection actualInspection = this.getInspectionById(id);
		
		actualInspection.setVehicle(inspection.getVehicle());
		actualInspection.setCustomer(inspection.getCustomer());
		actualInspection.setEmployee(inspection.getEmployee());
		actualInspection.setHasScratches(inspection.isHasScratches());
		actualInspection.setHasReplacementTires(inspection.isHasReplacementTires());
		actualInspection.setHasDamagedWindows(inspection.isHasDamagedWindows());
		actualInspection.setInspectionDate(inspection.getInspectionDate());
		actualInspection.setActive(inspection.isActive());
		actualInspection.setActive(inspection.isActive());
		actualInspection.setHasJack(inspection.isHasJack());
		actualInspection.setFuelLevel(inspection.getFuelLevel());
		
		return repo.save(actualInspection);
	}
	
	public void deleteInspection(int id) {
		repo.deleteById(id);
	}

}
