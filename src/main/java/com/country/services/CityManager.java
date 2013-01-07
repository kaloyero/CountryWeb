package com.country.services;

import java.util.List;

import com.country.hibernate.model.Ciudad;
import com.country.hibernate.model.Localidad;

public interface CityManager {


	void save(Ciudad dto);
	
	Ciudad findById(Integer id);
	
	List<Ciudad> listAll();

	Ciudad getCityTownsById(Integer id);

	List<Localidad> getTownsByIdCity(Integer id);
	
}
