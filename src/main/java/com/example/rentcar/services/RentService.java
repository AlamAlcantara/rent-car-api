package com.example.rentcar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.rentcar.entities.Rent;
import com.example.rentcar.repositories.RentRepository;

@Service
public class RentService {
	
	@Autowired
	private RentRepository repo;
	
	public List<Rent> getAll() {
		return repo.findAll();
	}
	
	public Rent getRentById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Rent createRent(Rent rent) {
		return repo.save(rent);
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
	
	public void deleteRent(int id) {
		repo.deleteById(id);
	}

}
