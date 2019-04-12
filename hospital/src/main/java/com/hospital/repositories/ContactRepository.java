package com.hospital.repositories;

import java.util.List;

import com.hospital.model.Contact;

public interface ContactRepository {

	Contact save(Contact contact);

	Contact updateContact(Contact contact);

	List<Contact> findByPatient(int id);

	Contact findOne(int id);

	List<Contact> findAll();
}
