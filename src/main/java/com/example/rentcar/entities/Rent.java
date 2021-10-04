package com.example.rentcar.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "rent")
public class Rent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer Id;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	@JsonIgnoreProperties({"rents", "inspections"})
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	@JsonIgnoreProperties("rents")
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonIgnoreProperties({"rents", "inspections"})
	private Customer customer;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Column(name = "amount_per_day")
	private double amountPerDay;
	
	@Column(name = "rent_comment")
	private String comment;
	
	@Column(name = "state")
	private String state;
	
	@OneToMany(mappedBy = "rent")
	@JsonIgnoreProperties({"rent", "vehicle", "employee", "customer"})
	private List<Inspection> inspections;
	

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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the amountPerDay
	 */
	public double getAmountPerDay() {
		return amountPerDay;
	}

	/**
	 * @param amountPerDay the amountPerDay to set
	 */
	public void setAmountPerDay(double amountPerDay) {
		this.amountPerDay = amountPerDay;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
	
}
