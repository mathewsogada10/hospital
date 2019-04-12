package com.hospital.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class PatientRepositoryJPA /* implements PatientRepository */ {

	// @PersistenceContext
	// private EntityManager patientManager;
	//
	// @Override
	// public Patient save(Patient patient) {
	// // TODO Auto-generated method stub
	// patientManager.persist(patient);
	// return patient;
	// }
	//
	// @Override
	// public List<Patient> findAll() {
	// // TODO Auto-generated method stub
	// return patientManager.createQuery("select p from Patient
	// p").getResultList();
	// }
	//
	// @Override
	// public Patient findOne(String id) {
	// // TODO Auto-generated method stub
	// return patientManager.find(Patient.class, id);
	// }
	//
	// @Override
	// public Patient updatePatient(Patient patient) {
	// patientManager.merge(patient);
	// return patient;
	//
	// }
	//
	// @Override
	// public void delete(Patient patient) {
	// // TODO Auto-generated method stub
	// // patientManager.detach(patient);
	// patientManager.remove(patient);
	// }
}
