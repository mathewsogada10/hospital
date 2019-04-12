package com.hospital.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.model.Patient;
import com.hospital.repositories.PatientRepository;

@RestController
@RequestMapping(value = "/api/")
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;

	@RequestMapping(value = "patient/all", method = RequestMethod.GET)
	public List<Patient> showPatientForm() {
		return (List<Patient>) patientRepository.findAll();
	}
}
