package com.hospital.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

/**
 * The persistent class for the enrollment database table.
 *
 */
@Entity
@NamedQuery(name = "Enrollment.findAll", query = "SELECT e FROM Enrollment e")
public class Enrollment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "int_code")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int intCode;

	@Temporal(TemporalType.DATE)
	@Column(name = "enrollment_date")
	private Date enrollmentDate;

	@NotNull
	@Column(name = "enrollment_no")
	private String enrollmentNo;

	// bi-directional many-to-one association to Patient
	@NotNull
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	public Enrollment() {
	}

	public int getIntCode() {
		return this.intCode;
	}

	public void setIntCode(int intCode) {
		this.intCode = intCode;
	}

	public Date getEnrollmentDate() {
		return this.enrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getEnrollmentNo() {
		return this.enrollmentNo;
	}

	public void setEnrollmentNo(String enrollmentNo) {
		this.enrollmentNo = enrollmentNo;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}