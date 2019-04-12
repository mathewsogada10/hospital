package com.hospital.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the county database table.
 *
 */
@Entity
@NamedQuery(name = "County.findAll", query = "SELECT c.countyName,c.intCode FROM County c")
public class County implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "int_code")
	private int intCode;

	@Column(name = "county_name")
	private String countyName;

	// bi-directional many-to-one association to Location
	@OneToMany(mappedBy = "county")
	private List<Location> locations;

	public County() {
	}

	public int getIntCode() {
		return this.intCode;
	}

	public void setIntCode(int intCode) {
		this.intCode = intCode;
	}

	public String getCountyName() {
		return this.countyName;
	}

	public void setCountyName(String cName) {
		this.countyName = cName;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setCounty(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setCounty(null);

		return location;
	}

}