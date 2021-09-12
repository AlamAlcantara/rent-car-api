package com.example.rentcar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.rentcar.entities.Brand;
import com.example.rentcar.repositories.BrandRepository;

@Service
public class BrandService {

	@Autowired
	private BrandRepository repo;
	
	
	public List<Brand> getBrands() {
		return repo.findAll();
	}
	
	public Brand getBrandById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Brand createBrand(Brand brand) {
		return repo.save(brand);
	}
	
	public Brand updateBrand(int id, Brand brand) { 
		Brand actualBrand = this.getBrandById(id);
		
		actualBrand.setDescription(brand.getDescription());
		actualBrand.setState(brand.isState());
		
		return repo.save(actualBrand);
	}
	
	public void deleteBrand(int id) {
		repo.deleteById(id);
	}
	
}
