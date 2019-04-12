package com.hospital.repositories;

import java.util.List;

import com.hospital.model.NextOfKin;

public interface KinRepository {

	NextOfKin save(NextOfKin kin);

	List<NextOfKin> findByPatient(int id);

	NextOfKin findOne(int id);

	List<NextOfKin> findAll();

	NextOfKin update(NextOfKin kin);
}
