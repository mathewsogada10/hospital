package com.hospital.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.model.User;

@Repository
@Transactional
public class UserRepositoryJPA implements UserRespository {

	@PersistenceContext
	private EntityManager userManager;

	@Override
	public User findUser(String username, String password) {
		// TODO Auto-generated method stub
		User result = null;
		TypedQuery<User> query = userManager
				.createQuery("SELECT u FROM User u WHERE u.username = :name and u.password = :pwd", User.class);
		query.setParameter("name", username);
		query.setParameter("pwd", password);
		List<User> users = query.getResultList();
		if (users.size() > 0) {
			result = users.get(0);
		}
		return result;
	}

}
