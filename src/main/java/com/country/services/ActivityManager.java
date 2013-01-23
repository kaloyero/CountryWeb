package com.country.services;

import java.util.List;

import com.country.hibernate.model.Actividad;

public interface ActivityManager extends AbstractManager<Actividad>{

	Actividad findById(Integer id);
	
	List<Actividad> findAllByActivityName(String name);
}
