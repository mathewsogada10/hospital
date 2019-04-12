package com.hospital.repositories;

import java.util.List;

import com.hospital.model.Enrollment;

public interface EnrollmentRepository {

	Enrollment save(Enrollment enrol);

	Enrollment update(Enrollment enrol);

	List<Enrollment> findByPatient(int id);

	Enrollment findOne(int id);

	List<Enrollment> findAll();
}
