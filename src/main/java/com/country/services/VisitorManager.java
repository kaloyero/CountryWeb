package com.country.services;

import com.country.hibernate.model.Autorizado;

public interface VisitorManager extends AbstractManager<Autorizado>{

	Autorizado findById(Integer id);
	
}
