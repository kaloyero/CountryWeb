package com.country.services;

import java.util.List;

import com.country.hibernate.model.Actividad;

public interface ActivityManager {

	Integer save(Actividad dto);
	
	Actividad findById(Integer id);
	
	List<Actividad> listAll();
	
	List<Actividad> findAllByActivityName(String name);

	void update(Actividad dto);
}
