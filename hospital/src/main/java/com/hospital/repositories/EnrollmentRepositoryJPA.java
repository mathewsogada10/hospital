package com.hospital.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.model.Enrollment;

@Repository
@Transactional
public class EnrollmentRepositoryJPA implements EnrollmentRepository {

	@PersistenceContext
	private EntityManager enrolManager;

	@Override
	public Enrollment save(Enrollment enrol) {
		// TODO Auto-generated method stub
		enrolManager.persist(enrol);
		return enrol;
	}

	@Override
	public List<Enrollment> findAll() {
		// TODO Auto-generated method stub
		return enrolManager.createQuery("SELECT e FROM Enrollment e").getResultList();
	}

	@Override
	public List<Enrollment> findByPatient(int id) {
		// TODO Auto-generated method stub
		TypedQuery<Enrollment> query = enrolManager
				.createQuery("SELECT e FROM Enrollment e WHERE e.patient.idNumber=:id", Enrollment.class);
		query.setParameter("id", id);
		List<Enrollment> enrolments = query.getResultList();
		return enrolments;
	}

	@Override
	public Enrollment findOne(int id) {
		// TODO Auto-generated method stub
		return enrolManager.find(Enrollment.class, id);
	}

	@Override
	public Enrollment update(Enrollment enrol) {
		// TODO Auto-generated method stub
		enrolManager.merge(enrol);
		return enrol;
	}
}
