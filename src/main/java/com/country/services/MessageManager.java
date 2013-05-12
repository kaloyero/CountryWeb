package com.country.services;

import com.country.hibernate.model.Mensaje;

public interface MessageManager extends AbstractManager<Mensaje>{

	Mensaje findById(Integer id);
	
}
