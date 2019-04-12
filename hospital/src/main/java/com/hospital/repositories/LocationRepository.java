package com.hospital.repositories;

import java.util.List;

import com.hospital.model.Location;

public interface LocationRepository {

	Location save(Location location);

	Location update(Location location);

	Location findOne(int id);

	List<Location> findByPatient(int id);

	List<Location> findAll();
}
