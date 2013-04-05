package com.country.services;

import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Recurso;

public interface ResourceManager extends AbstractManager<Recurso>{

	Recurso findById(Integer id);
	int save(Recurso dto,Recurso dtoTest);
	
}
