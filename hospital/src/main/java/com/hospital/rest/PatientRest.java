package com.hospital.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.model.Patient;
import com.hospital.repositories.PatientRepository;

@RestController
@RequestMapping(value = "rest/bio-data/")
public class PatientRest {

	@Autowired
	private PatientRepository patientRepository;

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public @ResponseBody List<Patient> showPatients() {
		return (List<Patient>) patientRepository.findAll();
	}
}
