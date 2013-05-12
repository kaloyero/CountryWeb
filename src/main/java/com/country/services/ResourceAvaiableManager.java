package com.country.services;

import java.util.List;

import com.country.hibernate.model.RecursoDisponibilidad;

public interface ResourceAvaiableManager extends AbstractManager<RecursoDisponibilidad>{
	
	public List<RecursoDisponibilidad> findResourcesAvaiableById(Integer id);
	
}
