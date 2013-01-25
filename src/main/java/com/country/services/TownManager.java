package com.country.services;

import com.country.hibernate.model.Localidad;

public interface TownManager extends AbstractManager<Localidad>{

	Localidad findById(Integer id);
	
}
