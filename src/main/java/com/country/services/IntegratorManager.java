package com.country.services;

import java.util.List;

import com.country.hibernate.model.Integrante;

public interface IntegratorManager {


	void save(Integrante dto);
	
	Integrante findById(Integer id);
	
	List<Integrante> listAll();

	Integrante getActivitiesById(Integer id);
	
}
