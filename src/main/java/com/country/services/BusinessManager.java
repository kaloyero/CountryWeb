package com.country.services;

import java.util.List;

import com.country.hibernate.model.Emprendimiento;

public interface BusinessManager {

	void save(Emprendimiento dto);
	
	Emprendimiento findById(Integer id);
	
	List<Emprendimiento> listAll();
	
}
