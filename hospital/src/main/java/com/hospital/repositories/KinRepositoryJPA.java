package com.hospital.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.model.NextOfKin;

@Repository
@Transactional
public class KinRepositoryJPA implements KinRepository {

	@PersistenceContext
	private EntityManager kinManager;

	@Override
	public NextOfKin save(NextOfKin kin) {
		// TODO Auto-generated method stub
		kinManager.persist(kin);
		return kin;
	}

	@Override
	public List<NextOfKin> findAll() {
		// TODO Auto-generated method stub
		return kinManager.createQuery("SELECT n FROM NextOfKin n").getResultList();
	}

	@Override
	public List<NextOfKin> findByPatient(int id) {
		// TODO Auto-generated method stub
		TypedQuery<NextOfKin> query = kinManager.createQuery("SELECT n FROM NextOfKin n WHERE n.patient.idNumber=:id",
				NextOfKin.class);
		query.setParameter("id", id);
		List<NextOfKin> kins = query.getResultList();
		return kins;
	}

	@Override
	public NextOfKin findOne(int id) {
		// TODO Auto-generated method stub
		TypedQuery<NextOfKin> query = kinManager.createQuery("SELECT n FROM NextOfKin n WHERE n.idNo=:id",
				NextOfKin.class);
		query.setParameter("id", id);
		NextOfKin kin = query.getSingleResult();
		return kin;
	}

	@Override
	public NextOfKin update(NextOfKin kin) {
		// TODO Auto-generated method stub
		kinManager.merge(kin);
		return kin;
	}
}
