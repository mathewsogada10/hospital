package com.hospital.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the historical_patient database table.
 *
 */
@Entity
@Table(name = "historical_patient")
@NamedQuery(name = "HistoricalPatient.findAll", query = "SELECT h FROM HistoricalPatient h")
public class HistoricalPatient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_number")
	private int idNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_deleted")
	private Date dateDeleted;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "first_name")
	private String firstName;

	private String gender;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "sir_name")
	private String sirName;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public HistoricalPatient() {
	}

	public int getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public Date getDateDeleted() {
		return this.dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSirName() {
		return this.sirName;
	}

	public void setSirName(String sirName) {
		this.sirName = sirName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}