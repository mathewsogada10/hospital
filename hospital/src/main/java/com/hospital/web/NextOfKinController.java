package com.hospital.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hospital.model.HistoricoEntity;
import com.hospital.model.NextOfKin;
import com.hospital.model.Patient;
import com.hospital.repositories.HistoricoEntityRepository;
import com.hospital.repositories.KinRepository;
import com.hospital.repositories.PatientRepository;
import com.hospital.rest.PatientApi;
import com.hospital.rest.PatientUtil;

@Controller
@RequestMapping(value = "/next-of-kin/")
public class NextOfKinController {

	@Autowired
	private KinRepository kinRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private HistoricoEntityRepository historicoEntityRepository;

	private static NextOfKin editKin;
	private String creation = "CREATION";
	private String modification = "EDITION";
	private String kinType = "KIN";

	@RequestMapping(value = "view_kin", method = RequestMethod.GET)
	public String showKin(NextOfKin reg, Model model) {

		model.addAttribute("kins", kinRepository.findAll());

		return "showKin";
	}

	@RequestMapping(value = "kin/{id}", method = RequestMethod.GET)
	public String showPatientKin(@PathVariable("id") int id, NextOfKin reg, Model model) {

		model.addAttribute("kins", kinRepository.findByPatient(id));

		return "showKin";
	}

	@RequestMapping(value = "editKin/{id}", method = RequestMethod.GET)
	public String editkinData(@PathVariable("id") int id, Model model) {
		model.addAttribute("kin", kinRepository.findOne(id));
		model.addAttribute("saveNextOfKin", new NextOfKin());
		model.addAttribute("gender", PatientApi.setGender());
		editKin = kinRepository.findOne(id);
		return "showEditKin";
	}

	@RequestMapping(value = "editKin/{id}", method = RequestMethod.POST)
	public String updatekin(NextOfKin kin, Model model) {
		HistoricoEntity hEntity = new HistoricoEntity();
		hEntity.setModification(modification);
		kin.setPatient(editKin.getPatient());
		if (kinRepository.update(kin) != null) {
			hEntity.setEntityCode(kin.getidNo());
			hEntity.setTypeOfEntity(kinType);
			hEntity.setUserId(UserController.logedUser.getIntCode());
			hEntity.setLastUpdate(new Date());
			historicoEntityRepository.save(hEntity);
			model.addAttribute("successKin", "Update Was SuccessFul for " + kin.getPatient().getIdNumber());
		} else {
			model.addAttribute("successKin", "Error Updating record for " + kin.getPatient().getIdNumber());
		}

		model.addAttribute("kins", kinRepository.findAll());
		return "showKin";
	}

	@RequestMapping(value = "kinToPatient/{id}", method = RequestMethod.GET)
	@Transactional
	public String kinToPatient(@PathVariable("id") int id, Model model) {
		HistoricoEntity hEntity = new HistoricoEntity();
		hEntity.setModification("CONVERSION");
		NextOfKin kin = kinRepository.findOne(id);
		Patient patient = new Patient();
		patient.setDateOfBirth(kin.getDateOfBirth());
		patient.setFirstName(kin.getFirstName());
		patient.setGender(kin.getGender());
		patient.setIdNumber(kin.getidNo());
		patient.setMiddleName(kin.getMiddleName());
		patient.setSirName(kin.getlastName());

		hEntity.setEntityCode(patient.getIdNumber());
		hEntity.setTypeOfEntity("PATIENT");
		hEntity.setUserId(UserController.logedUser.getIntCode());
		historicoEntityRepository.save(hEntity);

		patientRepository.save(patient);
		model.addAttribute("kinchange", "Next of kin added as Patient");
		model.addAttribute("patients", patientRepository.findAll());
		model.addAttribute("searchPatient", new PatientUtil());
		return "showPatients";
	}

	@RequestMapping(value = "add_kin", method = RequestMethod.GET)
	public String addKin(NextOfKin nextOfKin, Model model) {

		model.addAttribute("saveNextOfKin", new NextOfKin());
		model.addAttribute("patientNames", new PatientApi().getPatientNames(patientRepository));
		model.addAttribute("gender", PatientApi.setGender());
		return "addKin";
	}

	@RequestMapping(value = "add_kin", method = RequestMethod.POST)
	public String addKinPost(NextOfKin nextOfKin, Model model) {
		HistoricoEntity hEntity = new HistoricoEntity();
		hEntity.setModification(creation);
		String[] names = nextOfKin.getPatient().getFirstName().split(" ");
		Patient patient = patientRepository.findByFirstNameAndMiddleNameAndSirName(names[0], names[1], names[2]);
		nextOfKin.setPatient(patient);
		if (kinRepository.save(nextOfKin) != null) {
			hEntity.setEntityCode(nextOfKin.getidNo());
			hEntity.setTypeOfEntity(kinType);
			hEntity.setUserId(UserController.logedUser.getIntCode());
			hEntity.setLastUpdate(new Date());
			historicoEntityRepository.save(hEntity);
			model.addAttribute("kinsuccessmsg", "Next Of Kin Added Successfuly");
		} else {
			model.addAttribute("kinsuccessmsg", "Error encountered while tryig to save!");
		}
		model.addAttribute("kins", kinRepository.findAll());
		return "showKin";
	}
}
