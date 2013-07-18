package com.country.services;

import java.util.List;

import com.country.hibernate.model.RecursoDisponibilidad;

public interface ResourceAvaiableManager extends AbstractManager<RecursoDisponibilidad>{
	
	List<RecursoDisponibilidad> findResourcesAvaiableById(Integer id);

	List<RecursoDisponibilidad> findResourcesAvaiableByDayOfWeek(Integer resource,int dayOfweek);
}
