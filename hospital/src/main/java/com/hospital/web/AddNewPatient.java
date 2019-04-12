package com.hospital.web;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hospital.model.Contact;
import com.hospital.model.County;
import com.hospital.model.Enrollment;
import com.hospital.model.HistoricalPatient;
import com.hospital.model.HistoricoEntity;
import com.hospital.model.Location;
import com.hospital.model.NextOfKin;
import com.hospital.model.Patient;
import com.hospital.repositories.ContactRepository;
import com.hospital.repositories.CountyRepository;
import com.hospital.repositories.EnrollmentRepository;
import com.hospital.repositories.HistoricoEntityRepository;
import com.hospital.repositories.HistoricoPatientRepository;
import com.hospital.repositories.KinRepository;
import com.hospital.repositories.LocationRepository;
import com.hospital.repositories.PatientRepository;
import com.hospital.rest.PatientApi;
import com.hospital.rest.PatientUtil;

@Controller
@RequestMapping(value = "/bio-data/")
public class AddNewPatient {

	public static Patient patient;
	public County county;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private KinRepository kinRepository;

	@Autowired
	private EnrollmentRepository enrolRepository;

	@Autowired
	private CountyRepository countyRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private HistoricoPatientRepository hPatientRepository;

	@Autowired
	private HistoricoEntityRepository historicoEntityRepository;

	private String creation = "CREATION";
	private String modification = "EDITION";
	private String kinType = "KIN";
	private String locationType = "LOCATION";
	private String enrollmentType = "ENROLLMENT";
	private String bioData = "BIO DATA";
	private String contactType = "CONTACT";

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String showPatientForm(Model model) {
		model.addAttribute("savePatient", new Patient());
		model.addAttribute("saveContact", new Contact());
		model.addAttribute("saveLocation", new Location());
		model.addAttribute("saveNextOfKin", new NextOfKin());
		model.addAttribute("saveEnrollment", new Enrollment());
		model.addAttribute("gender", PatientApi.setGender());
		model.addAttribute("countyNames", countyRepository.findCountyNames());
		model.addAttribute("userprofile", UserController.logedUser);
		return "new";
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String savePatient(Patient reg, Contact contact, Location loc, NextOfKin kin, Enrollment en, Model model) {
		HistoricoEntity hEntity = new HistoricoEntity();
		hEntity.setModification(creation);
		if ((reg != null) && (reg.getSirName() != null)) {
			patient = patientRepository.save(reg);
			hEntity.setEntityCode(patient.getIdNumber());
			hEntity.setTypeOfEntity(bioData);
			hEntity.setUserId(UserController.logedUser.getIntCode());
			hEntity.setLastUpdate(new Date());
			historicoEntityRepository.save(hEntity);
		} else if (((contact != null) && (contact.getCellPhone() != null)) && (patient != null)) {
			contact.setPatient(patient);
			contact = contactRepository.save(contact);
			hEntity.setEntityCode(contact.getIntCode());
			hEntity.setTypeOfEntity(contactType);
			hEntity.setUserId(UserController.logedUser.getIntCode());
			hEntity.setLastUpdate(new Date());
			historicoEntityRepository.save(hEntity);
		} else if (((loc != null) && (loc.getSubCounty() != null)) && (patient != null)) {
			loc.setPatient(patient);
			County newcounty = loc.getCounty();
			county = countyRepository.findCounty(newcounty.getCountyName());
			loc.setCounty(county);
			loc = locationRepository.save(loc);
			hEntity.setEntityCode(loc.getIntCode());
			hEntity.setTypeOfEntity(locationType);
			hEntity.setUserId(UserController.logedUser.getIntCode());
			hEntity.setLastUpdate(new Date());
			historicoEntityRepository.save(hEntity);

		} else if (((kin.getlastName() != null)) && (patient != null)) {
			kin.setPatient(patient);
			kin = kinRepository.save(kin);
			hEntity.setEntityCode(kin.getidNo());
			hEntity.setTypeOfEntity(kinType);
			hEntity.setUserId(UserController.logedUser.getIntCode());
			hEntity.setLastUpdate(new Date());
			historicoEntityRepository.save(hEntity);
		} else if (((en != null) && (en.getEnrollmentNo() != null)) && (patient != null)) {
			en.setPatient(patient);
			en = enrolRepository.save(en);
			hEntity.setEntityCode(en.getIntCode());
			hEntity.setTypeOfEntity(enrollmentType);
			hEntity.setUserId(UserController.logedUser.getIntCode());
			hEntity.setLastUpdate(new Date());
			historicoEntityRepository.save(hEntity);
		}
		model.addAttribute("savePatient", new Patient());
		model.addAttribute("saveContact", new Contact());
		model.addAttribute("saveLocation", new Location());
		model.addAttribute("saveNextOfKin", new NextOfKin());
		model.addAttribute("saveEnrollment", new Enrollment());
		model.addAttribute("gender", PatientApi.setGender());
		model.addAttribute("countyNames", countyRepository.findCountyNames());
		model.addAttribute("userprofile", UserController.logedUser);
		return "new";
	}

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String showPatients(Patient reg, Model model) {
		model.addAttribute("patients", patientRepository.findAll());
		model.addAttribute("equations", PatientApi.setEquation());
		model.addAttribute("searchPatient", new PatientUtil());
		model.addAttribute("searchEq", "select--");
		model.addAttribute("userprofile", UserController.logedUser);
		return "showPatients";
	}

	@RequestMapping(value = "view", method = RequestMethod.POST)
	public String showPatientSearch(PatientUtil util, Model model) {
		model.addAttribute("patients",
				PatientApi.getPatientsByAge(util.getEquation(), util.getValueSearch(), patientRepository.findAll()));
		model.addAttribute("equations", PatientApi.setEquation());
		model.addAttribute("searchPatient", new PatientUtil());
		model.addAttribute("searchValue", util.getValueSearch());
		model.addAttribute("searchEq", util.getEquation());
		model.addAttribute("userprofile", UserController.logedUser);
		return "showPatients";
	}

	@RequestMapping(value = "view_deleted_patients", method = RequestMethod.GET)
	public String showHistoricoPatients(HistoricalPatient hPatient, Model model) {

		model.addAttribute("historicoPatients", hPatientRepository.findAll());

		return "showHistoricoPatients";
	}

	@RequestMapping(value = "editPatient/{id}", method = RequestMethod.GET)
	public String showEditPatients(@PathVariable("id") int id, Patient reg, Model model) {

		model.addAttribute("patient", patientRepository.findOne(id));
		model.addAttribute("editPatientData", new Patient());
		model.addAttribute("gender", PatientApi.setGender());
		return "showEditpatients";
	}

	@RequestMapping(value = "editPatient/{id}", method = RequestMethod.POST)
	public String editPatients(Patient patient, Model model) {
		HistoricoEntity hEntity = new HistoricoEntity();
		hEntity.setModification(modification);
		if (patientRepository.save(patient) != null) {
			hEntity.setEntityCode(patient.getIdNumber());
			hEntity.setTypeOfEntity(bioData);
			hEntity.setUserId(UserController.logedUser.getIntCode());
			hEntity.setLastUpdate(new Date());
			historicoEntityRepository.save(hEntity);
			model.addAttribute("success", "Update Was SuccessFul for " + patient.getIdNumber());
		} else {
			model.addAttribute("errormessage", "Error Updating record for " + patient.getIdNumber());
		}
		model.addAttribute("patients", patientRepository.findAll());
		model.addAttribute("equations", PatientApi.setEquation());
		model.addAttribute("searchPatient", new PatientUtil());
		return "showPatients";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	@Transactional
	public String deletePatient(@PathVariable("id") int id, Model model) {

		patient = patientRepository.findOne(id);
		HistoricalPatient hPatient = new HistoricalPatient();
		hPatient.setDateOfBirth(patient.getDateOfBirth());
		hPatient.setFirstName(patient.getFirstName());
		hPatient.setGender(patient.getGender());
		hPatient.setIdNumber(patient.getIdNumber());
		hPatient.setMiddleName(patient.getMiddleName());
		hPatient.setSirName(patient.getSirName());
		hPatient.setUser(UserController.logedUser);
		hPatient.setDateDeleted(new Date());
		if (hPatientRepository.save(hPatient) != null) {
			patientRepository.delete(patient);
			model.addAttribute("deleteMessgae", patient.getFirstName() + " Was Deleted succesfully");
		}

		model.addAttribute("patients", patientRepository.findAll());
		model.addAttribute("equations", PatientApi.setEquation());
		model.addAttribute("searchPatient", new PatientUtil());
		model.addAttribute("searchEq", "select--");
		return "showPatients";
	}

}
