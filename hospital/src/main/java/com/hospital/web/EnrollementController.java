package com.hospital.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hospital.model.Enrollment;
import com.hospital.model.HistoricoEntity;
import com.hospital.model.Patient;
import com.hospital.repositories.EnrollmentRepository;
import com.hospital.repositories.HistoricoEntityRepository;
import com.hospital.repositories.PatientRepository;
import com.hospital.rest.PatientApi;

@Controller
@RequestMapping(value = "/enrollment/")
public class EnrollementController {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private EnrollmentRepository enrolRepository;

	@Autowired
	private HistoricoEntityRepository historicoEntityRepository;

	private static Enrollment editEnrol;
	private String creation = "CREATION";
	private String modification = "EDITION";
	private String enrollmentType = "ENROLLMENT";

	@RequestMapping(value = "view_enrollment", method = RequestMethod.GET)
	public String showEnrollment(Enrollment reg, Model model) {

		model.addAttribute("enrollments", enrolRepository.findAll());

		return "showEnrollments";
	}

	@RequestMapping(value = "editEnrollment/{id}", method = RequestMethod.GET)
	public String editEnrollment(@PathVariable("id") int id, Model model) {
		model.addAttribute("enrollment", enrolRepository.findOne(id));
		model.addAttribute("saveEnrollment", new Enrollment());
		editEnrol = enrolRepository.findOne(id);
		return "showEditEnrollment";
	}

	@RequestMapping(value = "editEnrollment/{id}", method = RequestMethod.POST)
	public String updateEnrollment(Enrollment enrollment, Model model) {
		HistoricoEntity hEntity = new HistoricoEntity();
		hEntity.setModification(modification);
		enrollment.setPatient(editEnrol.getPatient());
		if (enrolRepository.update(enrollment) != null) {
			hEntity.setEntityCode(enrollment.getIntCode());
			hEntity.setTypeOfEntity(enrollmentType);
			hEntity.setUserId(UserController.logedUser.getIntCode());
			hEntity.setLastUpdate(new Date());
			historicoEntityRepository.save(hEntity);
			model.addAttribute("successEnroll", "Update Was SuccessFul for " + enrollment.getPatient().getIdNumber());
		} else {
			model.addAttribute("successEnroll", "Error Updating record for " + enrollment.getPatient().getIdNumber());
		}

		model.addAttribute("enrollments", enrolRepository.findAll());
		return "showEnrollments";
	}

	@RequestMapping(value = "add_enrollment", method = RequestMethod.GET)
	public String addEnrollment(Enrollment enrol, Model model) {
		model.addAttribute("saveEnrollment", new Enrollment());
		model.addAttribute("patientNames", new PatientApi().getPatientNames(patientRepository));
		return "addEnrollment";
	}

	@RequestMapping(value = "add_enrollment", method = RequestMethod.POST)
	public String addEnrollmentPost(Enrollment enrollment, Model model) {
		HistoricoEntity hEntity = new HistoricoEntity();
		hEntity.setModification(creation);
		String[] names = enrollment.getPatient().getFirstName().split(" ");
		Patient patient = patientRepository.findByFirstNameAndMiddleNameAndSirName(names[0], names[1], names[2]);
		enrollment.setPatient(patient);
		if (enrolRepository.save(enrollment) != null) {
			hEntity.setEntityCode(enrollment.getIntCode());
			hEntity.setTypeOfEntity(enrollmentType);
			hEntity.setUserId(UserController.logedUser.getIntCode());
			hEntity.setLastUpdate(new Date());
			historicoEntityRepository.save(hEntity);
			model.addAttribute("enrolSuccessmsg", "Enrollement Added Successfuly");
		} else {
			model.addAttribute("enrolSuccessmsg", "Error encountered while tryig to save!");
		}
		model.addAttribute("enrollments", enrolRepository.findAll());
		return "showEnrollments";
	}

	@RequestMapping(value = "enrol/{id}", method = RequestMethod.GET)
	public String showPatientEnrollment(@PathVariable("id") int id, Enrollment reg, Model model) {

		model.addAttribute("enrollments", enrolRepository.findByPatient(id));

		return "showEnrollments";
	}

}
