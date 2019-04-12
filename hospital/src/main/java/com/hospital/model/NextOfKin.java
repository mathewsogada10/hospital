package com.hospital.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

/**
 * The persistent class for the next_of_kin database table.
 *
 */
@Entity
@Table(name = "next_of_kin")
@NamedQuery(name = "NextOfKin.findAll", query = "SELECT n FROM NextOfKin n")
public class NextOfKin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	private String gender;

	@NotNull
	@Column(name = "middle_name")
	private String middleName;

	@NotNull
	@Column(name = "last_name")
	private String lastName;

	// bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	public NextOfKin() {
	}

	public int getidNo() {
		return this.idNo;
	}

	public void setidNo(int idNumber) {
		this.idNo = idNumber;
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

	public String getlastName() {
		return this.lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}