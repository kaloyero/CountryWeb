package com.country.services;

import java.util.List;

import com.country.hibernate.model.Ciudad;
import com.country.hibernate.model.Provincia;

public interface StateManager {


	void save(Provincia dto);
	
	Provincia findById(Integer id);
	
	List<Provincia> listAll();

	List<Ciudad> getCitiesByIdState(Integer id);

	Provincia getStateCitiesById(Integer id);
	
}
