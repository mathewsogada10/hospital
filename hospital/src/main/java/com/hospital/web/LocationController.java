package com.hospital.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hospital.model.County;
import com.hospital.model.HistoricoEntity;
import com.hospital.model.Location;
import com.hospital.model.Patient;
import com.hospital.repositories.CountyRepository;
import com.hospital.repositories.HistoricoEntityRepository;
import com.hospital.repositories.LocationRepository;
import com.hospital.repositories.PatientRepository;
import com.hospital.rest.PatientApi;

@Controller
@RequestMapping(value = "/location/")
public class LocationController {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private CountyRepository countyRepository;

	@Autowired
	private HistoricoEntityRepository historicoEntityRepository;

	private static Location editLocation;
	private String creation = "CREATION";
	private String modification = "EDITION";
	private String locationType = "LOCATION";
	public County county;

	@RequestMapping(value = "view_location", method = RequestMethod.GET)
	public String showLocation(Location reg, Model model) {

		List<Location> locations = locationRepository.findAll();
		for (Location location : locations) {
			location.setCounty(countyRepository.findOne(location.getCounty().getIntCode()));
		}
		model.addAttribute("locations", locations);

		return "showLocation";
	}

	@RequestMapping(value = "location/{id}", method = RequestMethod.GET)
	public String showPatientLocation(@PathVariable("id") int id, Location loc, Model model) {

		model.addAttribute("locations", locationRepository.findByPatient(id));

		return "showLocation";
	}

	@RequestMapping(value = "editLocation/{id}", method = RequestMethod.GET)
	public String editLoation(@PathVariable("id") int id, Model model) {
		editLocation = locationRepository.findOne(id);
		model.addAttribute("location", locationRepository.findOne(id));
		model.addAttribute("countyNames", countyRepository.findCountyNames());
		model.addAttribute("saveLocation", new Location());

		return "showEditLocation";
	}

	@RequestMapping(value = "editLocation/{id}", method = RequestMethod.POST)
	public String updateLocation(Location location, Model model) {
		HistoricoEntity hEntity = new HistoricoEntity();
		hEntity.setModification(modification);
		County newcounty = location.getCounty();
		county = countyRepository.findCounty(newcounty.getCountyName());
		location.setCounty(county);
		location.setPatient(editLocation.getPatient());
		if (locationRepository.update(location) != null) {
			hEntity.setEntityCode(location.getIntCode());
			hEntity.setTypeOfEntity(locationType);
			hEntity.setUserId(UserController.logedUser.getIntCode());
			hEntity.setLastUpdate(new Date());
			historicoEntityRepository.save(hEntity);
			model.addAttribute("successLocation", "Update Was SuccessFul for " + location.getSubCounty());
		} else {
			model.addAttribute("successLocation", "Error Updating record for " + location.getSubCounty());
		}

		model.addAttribute("locations", locationRepository.findAll());
		return "showLocation";
	}

	@RequestMapping(value = "add_location", method = RequestMethod.GET)
	public String addLocation(Location location, Model model) {
		model.addAttribute("saveLocation", new Location());
		model.addAttribute("patientNames", new PatientApi().getPatientNames(patientRepository));
		model.addAttribute("countyNames", countyRepository.findCountyNames());
		return "addLocation";
	}

	@RequestMapping(value = "add_location", method = RequestMethod.POST)
	public String addLocationPost(Location location, Model model) {
		HistoricoEntity hEntity = new HistoricoEntity();
		hEntity.setModification(creation);
		String[] names = location.getPatient().getFirstName().split(" ");
		Patient patient = patientRepository.findByFirstNameAndMiddleNameAndSirName(names[0], names[1], names[2]);
		location.setPatient(patient);
		County newcounty = location.getCounty();
		county = countyRepository.findCounty(newcounty.getCountyName());
		location.setCounty(county);
		if (locationRepository.save(location) != null) {
			hEntity.setEntityCode(location.getIntCode());
			hEntity.setTypeOfEntity(locationType);
			hEntity.setUserId(UserController.logedUser.getIntCode());
			hEntity.setLastUpdate(new Date());
			historicoEntityRepository.save(hEntity);
			model.addAttribute("locationSuccessmsg", "Location Added Successfuly");
		} else {
			model.addAttribute("locationSuccessmsg", "Error encountered while tryig to save!");
		}
		model.addAttribute("locations", locationRepository.findAll());
		return "showLocation";
	}

}
