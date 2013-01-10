package com.country.services;

import java.util.List;

import com.country.hibernate.model.Ciudad;
import com.country.hibernate.model.Localidad;

public interface CityManager extends AbstractManager<Ciudad>{

	Ciudad findById(Integer id);
	
	Ciudad getCityTownsById(Integer id);

	List<Localidad> getTownsByIdCity(Integer id);
	
}
