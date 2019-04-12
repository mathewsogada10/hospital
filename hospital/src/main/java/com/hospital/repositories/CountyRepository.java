package com.hospital.repositories;

import java.util.List;

import com.hospital.model.County;

public interface CountyRepository {

	County findCounty(String name);

	County findOne(int id);

	List<County> findAll();

	List<String> findCountyNames();
}
