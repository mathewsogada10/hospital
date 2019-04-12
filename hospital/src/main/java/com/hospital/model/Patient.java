package com.hospital.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the patient database table.
 *
 */
@Entity
@NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_number")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@NotNull
	@Column(name = "first_name")
	@Size(min = 1, message = "{firstname.size}")
	private String firstName;

	@NotNull
	private String gender;

	@Column(name = "middle_name")
	private String middleName;

	@NotNull
	@Column(name = "sir_name")
	private String sirName;

	// bi-directional many-to-one association to Contact
	@OneToMany(mappedBy = "patient", cascade = { CascadeType.ALL })
	private List<Contact> contacts;

	// bi-directional many-to-one association to Enrollment
	@OneToMany(mappedBy = "patient", cascade = { CascadeType.ALL })
	private List<Enrollment> enrollments;

	// bi-directional many-to-one association to Location
	// @OneToMany(fetch = FetchType.EAGER, mappedBy = "patient", cascade = {
	// CascadeType.ALL })
	@OneToMany(mappedBy = "patient", cascade = { CascadeType.ALL })
	private List<Location> locations;

	// bi-directional many-to-one association to NextOfKin
	@OneToMany(mappedBy = "patient", cascade = { CascadeType.ALL })
	private List<NextOfKin> nextOfKins;

	public Patient() {
	}

	public int getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
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

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setPatient(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setPatient(null);

		return contact;
	}

	public List<Enrollment> getEnrollments() {
		return this.enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Enrollment addEnrollment(Enrollment enrollment) {
		getEnrollments().add(enrollment);
		enrollment.setPatient(this);

		return enrollment;
	}

	public Enrollment removeEnrollment(Enrollment enrollment) {
		getEnrollments().remove(enrollment);
		enrollment.setPatient(null);

		return enrollment;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setPatient(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setPatient(null);

		return location;
	}

	public List<NextOfKin> getNextOfKins() {
		return this.nextOfKins;
	}

	public void setNextOfKins(List<NextOfKin> nextOfKins) {
		this.nextOfKins = nextOfKins;
	}

	public NextOfKin addNextOfKin(NextOfKin nextOfKin) {
		getNextOfKins().add(nextOfKin);
		nextOfKin.setPatient(this);

		return nextOfKin;
	}

	public NextOfKin removeNextOfKin(NextOfKin nextOfKin) {
		getNextOfKins().remove(nextOfKin);
		nextOfKin.setPatient(null);

		return nextOfKin;
	}

}