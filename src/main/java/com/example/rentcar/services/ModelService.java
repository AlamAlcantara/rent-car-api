package com.example.rentcar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.rentcar.entities.Model;
import com.example.rentcar.repositories.ModelRepository;

@Service
public class ModelService {
	
	@Autowired
	private ModelRepository repo;
	
	public List<Model> getModels() {
		return repo.findAll();
	}
	
	public Model getModelById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Model createModel(Model model) {
		return repo.save(model);
	}
	
	public Model updateModel(int id, Model model) { 
		Model actualModel = this.getModelById(id);
		
		actualModel.setDescription(model.getDescription());
		actualModel.setActive(model.isActive());
		
		return repo.save(actualModel);
	}
	
	public void deleteModel(int id) {
		repo.deleteById(id);
	}

}
