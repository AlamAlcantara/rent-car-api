package com.example.rentcar.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer Id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "chassis_number")
	private String chassisNumber;
	
	@Column(name = "engine_number")
	private String engineNumber;
	
	@Column(name = "license_plate")
	private String licensePlate;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_type_id")
	@JsonIgnoreProperties("vehicles")
	private VehicleType vehicleType;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	@JsonIgnoreProperties({"vehicles", "models"})
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "model_id")
	@JsonIgnoreProperties({"vehicles", "brand"})
	private Model model;
	
	@ManyToOne
	@JoinColumn(name = "fuel_type_id")
	@JsonIgnoreProperties("vehicles")
	private FuelType fuelType;
	
	@OneToMany(mappedBy = "vehicle")
	@JsonIgnoreProperties("vehicle")
	private List<Inspection> inspections;
	
	@OneToMany(mappedBy = "vehicle")
	@JsonIgnoreProperties("vehicle")
	private List<Rent> rents;

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
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the chassisNumber
	 */
	public String getChassisNumber() {
		return chassisNumber;
	}

	/**
	 * @param chassisNumber the chassisNumber to set
	 */
	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	/**
	 * @return the engineNumber
	 */
	public String getEngineNumber() {
		return engineNumber;
	}

	/**
	 * @param engineNumber the engineNumber to set
	 */
	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	/**
	 * @return the licensePlate
	 */
	public String getLicensePlate() {
		return licensePlate;
	}

	/**
	 * @param licensePlate the licensePlate to set
	 */
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	/**
	 * @return the vehicleType
	 */
	public VehicleType getVehicleType() {
		return vehicleType;
	}

	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * @return the fuelType
	 */
	public FuelType getFuelType() {
		return fuelType;
	}

	/**
	 * @param fuelType the fuelType to set
	 */
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	/**
	 * @return the inspections
	 */
	public List<Inspection> getInspections() {
		return inspections;
	}

	/**
	 * @param inspections the inspections to set
	 */
	public void setInspections(List<Inspection> inspections) {
		this.inspections = inspections;
	}

	/**
	 * @return the rents
	 */
	public List<Rent> getRents() {
		return rents;
	}

	/**
	 * @param rents the rents to set
	 */
	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}
	
}
