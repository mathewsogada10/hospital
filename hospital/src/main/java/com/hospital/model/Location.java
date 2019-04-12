package com.hospital.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the location database table.
 *
 */
@Entity
@NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "int_code")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int intCode;

	@NotNull
	@Column(name = "sub_county")
	private String subCounty;

	@NotNull
	private String village;

	// bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	// bi-directional many-to-one association to County
	@NotNull
	@ManyToOne
	@JoinColumn(name = "county_code")
	private County county;

	public Location() {
	}

	public int getIntCode() {
		return this.intCode;
	}

	public void setIntCode(int intCode) {
		this.intCode = intCode;
	}

	public String getSubCounty() {
		return this.subCounty;
	}

	public void setSubCounty(String subCounty) {
		this.subCounty = subCounty;
	}

	public String getVillage() {
		return this.village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public County getCounty() {
		return this.county;
	}

	public void setCounty(County county) {
		this.county = county;
	}

}