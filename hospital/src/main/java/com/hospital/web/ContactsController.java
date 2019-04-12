package com.hospital.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hospital.model.Contact;
import com.hospital.model.HistoricoEntity;
import com.hospital.model.Patient;
import com.hospital.repositories.ContactRepository;
import com.hospital.repositories.HistoricoEntityRepository;
import com.hospital.repositories.PatientRepository;
import com.hospital.rest.PatientApi;

@Controller
@RequestMapping(value = "/contacts/")
public class ContactsController {
	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private HistoricoEntityRepository historicoEntityRepository;

	private String creation = "CREATION";
	private String modification = "EDITION";
	private String contactType = "CONTACT";
	private static Contact con;

	@RequestMapping(value = "view_contacts", method = RequestMethod.GET)
	public String showContact(Contact reg, Model model) {

		model.addAttribute("contacts", contactRepository.findAll());

		return "showContacts";
	}

	@RequestMapping(value = "contacts/{id}", method = RequestMethod.GET)
	public String showPatientContact(@PathVariable("id") int id, Contact contact, Model model) {

		model.addAttribute("contacts", contactRepository.findByPatient(id));

		return "showContacts";
	}

	@RequestMapping(value = "editContact/{id}", method = RequestMethod.GET)
	public String editPatientContact(@PathVariable("id") int id, Contact contact, Model model) {
		con = contactRepository.findOne(id);
		model.addAttribute("contact", contactRepository.findOne(id));
		model.addAttribute("editContactData", new Contact());

		return "showEditContacts";
	}

	@RequestMapping(value = "editContact/{id}", method = RequestMethod.POST)
	public String updatePatientContact(Contact contact, Model model) {
		HistoricoEntity hEntity = new HistoricoEntity();
		hEntity.setModification(modification);
		contact.setPatient(con.getPatient());
		if (contactRepository.updateContact(contact) != null) {
			hEntity.setEntityCode(contact.getIntCode());
			hEntity.setTypeOfEntity(contactType);
			hEntity.setUserId(UserController.logedUser.getIntCode());
			hEntity.setLastUpdate(new Date());
			historicoEntityRepository.save(hEntity);
			model.addAttribute("successContact", "Update Was SuccessFul for " + contact.getPatient().getIdNumber());
		} else {
			model.addAttribute("errormessageContact",
					"Error Updating record for " + contact.getPatient().getIdNumber());
		}

		model.addAttribute("contacts", contactRepository.findAll());
		return "showContacts";
	}

	@RequestMapping(value = "add_contact", method = RequestMethod.POST)
	public String addContactPost(Contact contact, Model model) {
		HistoricoEntity hEntity = new HistoricoEntity();
		hEntity.setModification(creation);
		String[] names = contact.getPatient().getFirstName().split(" ");
		Patient patient = patientRepository.findByFirstNameAndMiddleNameAndSirName(names[0], names[1], names[2]);
		contact.setPatient(patient);
		if (contactRepository.save(contact) != null) {
			hEntity.setEntityCode(contact.getIntCode());
			hEntity.setTypeOfEntity(contactType);
			hEntity.setUserId(UserController.logedUser.getIntCode());
			hEntity.setLastUpdate(new Date());
			historicoEntityRepository.save(hEntity);
			model.addAttribute("contactSuccessmsg", "Contact Added Successfuly");
		} else {
			model.addAttribute("contactSuccessmsg", "Error encountered while tryig to save!");
		}
		model.addAttribute("contacts", contactRepository.findAll());
		return "showContacts";
	}

	@RequestMapping(value = "add_contact", method = RequestMethod.GET)
	public String addContact(Contact contact, Model model) {
		model.addAttribute("saveContact", new Contact());
		model.addAttribute("patientNames", new PatientApi().getPatientNames(patientRepository));
		model.addAttribute("gender", PatientApi.setGender());
		return "addContact";
	}

}
