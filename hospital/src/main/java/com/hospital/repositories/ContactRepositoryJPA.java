package com.hospital.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.model.Contact;

@Repository
@Transactional
public class ContactRepositoryJPA implements ContactRepository {

	@PersistenceContext
	private EntityManager contactManager;

	@Override
	public Contact save(Contact contact) {
		// TODO Auto-generated method stub
		contactManager.persist(contact);
		return contact;
	}

	@Override
	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		return contactManager.createQuery("select c from Contact c").getResultList();
	}

	@Override
	public List<Contact> findByPatient(int id) {
		// TODO Auto-generated method stub
		TypedQuery<Contact> query = contactManager.createQuery("SELECT c FROM Contact c WHERE c.patient.idNumber=:id",
				Contact.class);
		query.setParameter("id", id);
		List<Contact> contacts = query.getResultList();
		return contacts;
	}

	@Override
	public Contact updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactManager.merge(contact);
	}

	@Override
	public Contact findOne(int id) {
		// TODO Auto-generated method stub
		return contactManager.find(Contact.class, id);
	}

}
