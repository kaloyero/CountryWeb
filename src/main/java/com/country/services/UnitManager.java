package com.country.services;

import java.util.List;

import com.country.hibernate.model.Unidad;

public interface UnitManager {

	void save(Unidad dto);
	
	Unidad findById(Integer id);
	
	List<Unidad> listAll();
	
}
