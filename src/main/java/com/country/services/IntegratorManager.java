package com.country.services;

import com.country.hibernate.model.Integrante;

public interface IntegratorManager extends AbstractManager<Integrante>{
	
	Integrante findById(Integer id);
	
	Integrante getActivitiesById(Integer id);
	
}
