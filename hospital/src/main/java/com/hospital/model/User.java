package com.hospital.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the user database table.
 *
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "int_code")
	private int intCode;

	private String password;

	private String username;

	// bi-directional many-to-one association to Contact
	@OneToMany(mappedBy = "user")
	private List<HistoricalPatient> historicalPatient;

	public User() {
	}

	public List<HistoricalPatient> getHistoricalPatient() {
		return historicalPatient;
	}

	public void setHistoricalPatient(List<HistoricalPatient> historicalPatient) {
		this.historicalPatient = historicalPatient;
	}

	public int getIntCode() {
		return this.intCode;
	}

	public void setIntCode(int intCode) {
		this.intCode = intCode;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}