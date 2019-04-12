package com.hospital.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.model.County;

@Repository
@Transactional
public class CountyRepositoryJPA implements CountyRepository {

	@PersistenceContext
	private EntityManager countyManager;

	@Override
	public County findCounty(String name) {
		// TODO Auto-generated method stub
		County result = null;
		TypedQuery<County> query = countyManager.createQuery("SELECT c FROM County c WHERE c.countyName = :name",
				County.class);
		query.setParameter("name", name);
		List<County> county = query.getResultList();
		if (county.size() > 0) {
			result = county.get(0);
		}
		return result;
	}

	@Override
	public List<String> findCountyNames() {
		// TODO Auto-generated method stub
		List<County> counties = findAll();
		List<String> result = new ArrayList<>();
		for (County county : counties) {
			result.add(county.getCountyName());
		}
		return result;
	}

	@Override
	public List<County> findAll() {
		// TODO Auto-generated method stub
		return countyManager.createQuery("select c from County c").getResultList();
	}

	@Override
	public County findOne(int id) {
		// TODO Auto-generated method stub
		County result = null;
		TypedQuery<County> query = countyManager.createQuery("SELECT c FROM County c WHERE c.intCode = :id",
				County.class);
		query.setParameter("id", id);
		List<County> county = query.getResultList();
		if (county.size() > 0) {
			result = county.get(0);
		}
		return result;
	}

}
