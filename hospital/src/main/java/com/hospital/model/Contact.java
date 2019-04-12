package com.hospital.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the contact database table.
 *
 */
@Entity
@NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "int_code")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int intCode;

	@NotNull
	@Column(name = "alternate_cell")
	private String alternateCell;

	@NotNull
	@Column(name = "cell_phone")
	private String cellPhone;

	@NotNull
	private String email;

	// bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	public Contact() {
	}

	public int getIntCode() {
		return this.intCode;
	}

	public void setIntCode(int intCode) {
		this.intCode = intCode;
	}

	public String getAlternateCell() {
		return this.alternateCell;
	}

	public void setAlternateCell(String alternateCell) {
		this.alternateCell = alternateCell;
	}

	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}