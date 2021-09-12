package com.example.rentcar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.rentcar.entities.WorkShift;
import com.example.rentcar.repositories.WorkShiftRepository;

@Service
public class WorkShiftService {
	
	@Autowired
	private WorkShiftRepository repo;
	
	public List<WorkShift> getAll() {
		return repo.findAll();
	}
	
	public WorkShift getWorkShiftById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public WorkShift createWorkShift(WorkShift workShift) {
		return repo.save(workShift);
	}
	
	public WorkShift updateWorkShift(int id, WorkShift workShift) { 
		WorkShift actualWorkShift = this.getWorkShiftById(id);
		actualWorkShift.setDescription(workShift.getDescription());
		
		return repo.save(actualWorkShift);
	}
	
	public void deleteWorkShift(int id) {
		repo.deleteById(id);
	}

}
