package com.example.rentcar.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.rentcar.enums.CustomerState;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer Id;
	
	@Column(name = "customer_name")
	private String name;
	
	@Column(name = "personal_id")
	private String personalId;
	
	@Column(name = "state")
	@Enumerated(EnumType.STRING)
	private CustomerState state;
	
	@Column(name = "credit_card")
	private String creditCard;
	
	@Column(name = "credit_limit")
	private double creditLimit;
	
	@ManyToOne
	@JoinColumn(name = "customer_type_id")
	@JsonIgnoreProperties("customers")
	private CustomerType customerType;
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnoreProperties("customer")
	private List<Inspection> inspections;
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnoreProperties("customer")
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the personalId
	 */
	public String getPersonalId() {
		return personalId;
	}

	/**
	 * @param personalId the personalId to set
	 */
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}

	/**
	 * @return the state
	 */
	public CustomerState getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(CustomerState state) {
		this.state = state;
	}

	/**
	 * @return the creditCard
	 */
	public String getCreditCard() {
		return creditCard;
	}

	/**
	 * @param creditCard the creditCard to set
	 */
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	/**
	 * @return the creditLimit
	 */
	public double getCreditLimit() {
		return creditLimit;
	}

	/**
	 * @param creditLimit the creditLimit to set
	 */
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	/**
	 * @return the customerType
	 */
	public CustomerType getCustomerType() {
		return customerType;
	}

	/**
	 * @param customerType the customerType to set
	 */
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
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
