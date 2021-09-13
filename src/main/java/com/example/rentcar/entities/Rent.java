package com.example.rentcar.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
	@JsonIgnoreProperties("rents")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	@JsonIgnoreProperties("rents")
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonIgnoreProperties("rents")
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
	
	@Transient
	private long daysQuantity;

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
	 * @return the daysQuantity
	 * @throws ParseException 
	 */
	public long getDaysQuantity() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date formattedStartDate = sdf.parse(startDate.toString());
		Date formattedEndDate = sdf.parse(endDate.toString());
		
		LocalDate date1 = formattedStartDate.toInstant()
				.atZone(ZoneId.systemDefault()).toLocalDate();
		
		LocalDate date2 = formattedEndDate.toInstant()
				.atZone(ZoneId.systemDefault()).toLocalDate();
		
		return ChronoUnit.DAYS.between(date1, date2);
	}
	
	/**
	 * @param daysQuantity the daysQuantity to set
	 */
	public void setDaysQuantity(int daysQuantity) {
		this.daysQuantity = daysQuantity;
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
	
}
