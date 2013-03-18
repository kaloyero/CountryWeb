package com.country.services;

import java.util.List;

import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Asignacion;

public interface ActivityManager extends AbstractManager<Actividad>{

	Actividad findById(Integer id);
	
	int save(Actividad dto, Double tarifa);
	
	void saveAsignation(List<Asignacion> asignaciones,int id);
	
	List<Actividad> findAllByActivityName(String name);
	
	List<Asignacion> findAsignacionByIdAct(Integer id);
	
	void update(Actividad actividad, List<Asignacion> listAsignacion, Double tarifa);
	
}
