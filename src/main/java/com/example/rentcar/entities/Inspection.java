package com.example.rentcar.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.rentcar.enums.InspectionType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "inspection")
public class Inspection implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer Id;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	@JsonIgnoreProperties({"inspections", "rents"})
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonIgnoreProperties({"inspections", "rents"})
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	@JsonIgnoreProperties({"inspections", "rents"})
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "rent_id")
	@JsonIgnoreProperties({"inspections", "vehicle", "employee", "customer"})
	private Rent rent;
	
	@Column(name = "fuel_level")
	private String fuelLevel;
	
	@Column(name = "has_scratches")
	private boolean hasScratches;
	
	@Column(name = "has_replacement_tires")
	private boolean hasReplacementTires;
	
	@Column(name = "has_jack")
	private boolean hasJack;
	
	@Column(name = "has_damaged_windows")
	private boolean hasDamagedWindows;
	
	@Column(name = "inspection_date")
	@Temporal(TemporalType.DATE)
	private Date inspectionDate;
	
	@Column(name = "state")
	private boolean active;
	
	@Column(name = "inspection_type")
	@Enumerated(EnumType.STRING)
	private InspectionType inspectionType;

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
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the fuelLevel
	 */
	public String getFuelLevel() {
		return fuelLevel;
	}

	/**
	 * @param fuelLevel the fuelLevel to set
	 */
	public void setFuelLevel(String fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	/**
	 * @return the hasScratches
	 */
	public boolean isHasScratches() {
		return hasScratches;
	}

	/**
	 * @param hasScratches the hasScratches to set
	 */
	public void setHasScratches(boolean hasScratches) {
		this.hasScratches = hasScratches;
	}

	/**
	 * @return the hasReplacementTires
	 */
	public boolean isHasReplacementTires() {
		return hasReplacementTires;
	}

	/**
	 * @param hasReplacementTires the hasReplacementTires to set
	 */
	public void setHasReplacementTires(boolean hasReplacementTires) {
		this.hasReplacementTires = hasReplacementTires;
	}

	/**
	 * @return the hasJack
	 */
	public boolean isHasJack() {
		return hasJack;
	}

	/**
	 * @param hasJack the hasJack to set
	 */
	public void setHasJack(boolean hasJack) {
		this.hasJack = hasJack;
	}

	/**
	 * @return the hasDamagedWindows
	 */
	public boolean isHasDamagedWindows() {
		return hasDamagedWindows;
	}

	/**
	 * @param hasDamagedWindows the hasDamagedWindows to set
	 */
	public void setHasDamagedWindows(boolean hasDamagedWindows) {
		this.hasDamagedWindows = hasDamagedWindows;
	}

	/**
	 * @return the inspectionDate
	 */
	public Date getInspectionDate() {
		return inspectionDate;
	}

	/**
	 * @param inspectionDate the inspectionDate to set
	 */
	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
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
	 * @return the rent
	 */
	public Rent getRent() {
		return rent;
	}

	/**
	 * @param rent the rent to set
	 */
	public void setRent(Rent rent) {
		this.rent = rent;
	}

	/**
	 * @return the inspectionType
	 */
	public InspectionType getInspectionType() {
		return inspectionType;
	}

	/**
	 * @param inspectionType the inspectionType to set
	 */
	public void setInspectionType(InspectionType inspectionType) {
		this.inspectionType = inspectionType;
	}
	
}
