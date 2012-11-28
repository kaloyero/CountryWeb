package com.country.services;

import com.country.hibernate.model.Actividad;

public interface ActivityManager {


	Integer createActivity(Actividad dto);
	
	Actividad findById(Integer id);
	
	

}
