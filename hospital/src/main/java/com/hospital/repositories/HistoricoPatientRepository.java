package com.hospital.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hospital.model.HistoricalPatient;

public interface HistoricoPatientRepository extends CrudRepository<HistoricalPatient, Integer> {

}
