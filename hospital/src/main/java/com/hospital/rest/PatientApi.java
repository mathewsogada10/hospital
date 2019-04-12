package com.hospital.rest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import com.hospital.model.Patient;
import com.hospital.repositories.PatientRepository;

@Controller
public class PatientApi {

	static String[] operators = { "select--", "=", "<", ">", "<=", ">=" };

	public List<String> getPatientNames(PatientRepository patientResp) {
		Iterable<Patient> patients = patientResp.findAll();
		List<String> name = new ArrayList<>();
		for (Patient p : patients) {
			name.add(p.getFirstName() + " " + p.getMiddleName() + " " + p.getSirName());
		}
		return name;
	}

	public static List<String> setGender() {
		List<String> gender = new ArrayList<String>();
		gender.add("Male");
		gender.add("Female");
		return gender;
	}

	public static List<PatientUtil> setEquation() {
		List<PatientUtil> eq = new ArrayList<PatientUtil>();
		for (String operator : operators) {
			PatientUtil PatientUtil = new PatientUtil();
			PatientUtil.setEquation(operator);
			eq.add(PatientUtil);
		}
		return eq;
	}

	public static List<Patient> getPatientsByAge(String eq, int ageValue, Iterable<Patient> iterable) {
		List<Patient> resultPatients = new ArrayList<>();
		for (Patient patient : iterable) {

			int age = 0;
			try {
				age = getAge(toCalendar(patient.getDateOfBirth()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			switch (eq) {
			case "=":
				if (age == ageValue) {
					resultPatients.add(patient);
				}
				break;
			case "<=":
				if (age <= ageValue) {
					resultPatients.add(patient);
				}
				break;
			case ">=":
				if (age >= ageValue) {
					resultPatients.add(patient);
				}
				break;
			case ">":
				if (age > ageValue) {
					resultPatients.add(patient);
				}
				break;
			case "<":
				if (age < ageValue) {
					resultPatients.add(patient);
				}
				break;
			}
		}

		return resultPatients;
	}

	public static int getAge(Calendar dob) throws Exception {
		Calendar today = Calendar.getInstance();

		int curYear = today.get(Calendar.YEAR);
		int dobYear = dob.get(Calendar.YEAR);

		int age = curYear - dobYear;

		// if dob is month or day is behind today's month or day

		// reduce age by 1

		int curMonth = today.get(Calendar.MONTH);

		int dobMonth = dob.get(Calendar.MONTH);

		if (dobMonth > curMonth) { // this year can't be counted!

			age--;

		} else if (dobMonth == curMonth) { // same month? check for day

			int curDay = today.get(Calendar.DAY_OF_MONTH);

			int dobDay = dob.get(Calendar.DAY_OF_MONTH);

			if (dobDay > curDay) { // this year can't be counted!

				age--;

			}

		}
		return age;
	}

	public static Calendar toCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
}
