package com.hospital.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.model.Location;

@Repository
@Transactional
public class LocationRepositoryJPA implements LocationRepository {

	@PersistenceContext
	private EntityManager locationManager;

	@Override
	public Location save(Location location) {
		// TODO Auto-generated method stub
		locationManager.persist(location);
		return location;
	}

	@Override
	public List<Location> findAll() {
		// TODO Auto-generated method stub
		return locationManager.createQuery("select l from Location l").getResultList();
	}

	@Override
	public List<Location> findByPatient(int id) {
		// TODO Auto-generated method stub
		TypedQuery<Location> query = locationManager
				.createQuery("SELECT l FROM Location l WHERE l.patient.idNumber=:id", Location.class);
		query.setParameter("id", id);
		List<Location> locations = query.getResultList();
		return locations;
	}

	@Override
	public Location findOne(int id) {
		// TODO Auto-generated method stub
		return locationManager.find(Location.class, id);
	}

	@Override
	public Location update(Location location) {
		// TODO Auto-generated method stub
		locationManager.merge(location);
		return location;
	}

}
