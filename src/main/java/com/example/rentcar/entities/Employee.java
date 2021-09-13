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
@Table(name = "employee")
public class Employee implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer Id;
	
	@Column(name = "employee_name")
	private String name;
	
	@Column(name = "personal_id")
	private String personalId;
	
	@Column(name = "state")
	private boolean active;
	
	@ManyToOne()
	@JoinColumn(name = "work_shift_id")
	@JsonIgnoreProperties("employees")
	private WorkShift workShift;
	
	@Column(name = "commission_percentage")
	private double commissionPercentage;
	
	@Column(name = "entry_date")
	@Temporal(TemporalType.DATE)
	private Date entryDate;
	
	@OneToMany(mappedBy = "employee")
	@JsonIgnoreProperties("employee")
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
	 * @return the workShift
	 */
	public WorkShift getWorkShift() {
		return workShift;
	}

	/**
	 * @param workShift the workShift to set
	 */
	public void setWorkShift(WorkShift workShift) {
		this.workShift = workShift;
	}

	/**
	 * @return the commissionPercentage
	 */
	public double getCommissionPercentage() {
		return commissionPercentage;
	}

	/**
	 * @param commissionPercentage the commissionPercentage to set
	 */
	public void setCommissionPercentage(double commissionPercentage) {
		this.commissionPercentage = commissionPercentage;
	}

	/**
	 * @return the entryDate
	 */
	public Date getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
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
