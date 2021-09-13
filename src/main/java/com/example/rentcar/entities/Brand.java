package com.example.rentcar.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "BRAND")
public class Brand implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer Id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "state")
	private boolean active;
	
	@OneToMany(mappedBy = "brand")
	@JsonIgnoreProperties("brand")
	private List<Model> models;
	
	@OneToMany(mappedBy = "brand")
	@JsonIgnoreProperties("brand")
	private List<Vehicle> vehicles;
	
	public Brand() {
		this.description = "";
		this.active = false;
	}

	/**
	 * @param description
	 * @param state
	 */
	public Brand(String description, boolean state) {
		this.description = description;
		this.active = state;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the models
	 */
	public List<Model> getModels() {
		return models;
	}

	/**
	 * @param models the models to set
	 */
	public void setModels(List<Model> models) {
		this.models = models;
	}

	/**
	 * @return the vehicles
	 */
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
}
