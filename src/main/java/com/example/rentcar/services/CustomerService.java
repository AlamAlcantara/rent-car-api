package com.example.rentcar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.rentcar.entities.Customer;
import com.example.rentcar.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;
	
	public List<Customer> getAll() {
		return repo.findAll();
	}
	
	public Customer getCustomerById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Customer createCustomer(Customer customer) {
		return repo.save(customer);
	}
	
	public Customer updateCustomer(int id, Customer customer) { 
		Customer actualCustomer = this.getCustomerById(id);
		
		actualCustomer.setName(customer.getName());
		actualCustomer.setCreditCard(customer.getCreditCard());
		actualCustomer.setCreditLimit(customer.getCreditLimit());
		actualCustomer.setCustomerType(customer.getCustomerType());
		actualCustomer.setPersonalId(customer.getPersonalId());
		actualCustomer.setState(customer.getState());
		
		return repo.save(actualCustomer);
	}
	
	public void deleteCustomer(int id) {
		repo.deleteById(id);
	}

}
