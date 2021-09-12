package com.example.rentcar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.rentcar.entities.CustomerType;
import com.example.rentcar.repositories.CustomerTypeRepository;

@Service
public class CustomerTypeService {
	
	@Autowired
	private CustomerTypeRepository repo;
	
	public List<CustomerType> getAll() {
		return repo.findAll();
	}
	
	public CustomerType getCustomerTypeById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public CustomerType createCustomerType(CustomerType customerType) {
		return repo.save(customerType);
	}
	
	public CustomerType updateCustomerType(int id, CustomerType customerType) { 
		CustomerType actualCustomerType = this.getCustomerTypeById(id);
		actualCustomerType.setDescription(customerType.getDescription());
		
		return repo.save(actualCustomerType);
	}
	
	public void deleteCustomerType(int id) {
		repo.deleteById(id);
	}

}
