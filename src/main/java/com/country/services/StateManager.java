package com.country.services;

import java.util.List;

import com.country.hibernate.model.Ciudad;
import com.country.hibernate.model.Provincia;

public interface StateManager extends AbstractManager<Provincia>{

	Provincia findById(Integer id);

	List<Ciudad> getCitiesByIdState(Integer id);

	Provincia getStateCitiesById(Integer id);
	
}
