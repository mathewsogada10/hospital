package com.hospital.repositories;

import org.springframework.data.repository.CrudRepository;
import com.hospital.model.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

	Patient findByFirstNameAndMiddleNameAndSirName(String firstname, String middlename, String sirname);

	/*
	 * @Query(nativeQuery = true, value = ":script") List<Patient>
	 * findByAge(@Param("script") String script);
	 */
}
