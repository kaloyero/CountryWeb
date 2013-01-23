package com.country.services;

import com.country.hibernate.model.Unidad;

public interface UnitManager extends AbstractManager<Unidad>{

	Unidad findById(Integer id);
	
}
