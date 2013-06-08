package com.country.services;

import java.util.List;

import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Asignacion;

public interface ActivityManager extends AbstractManager<Actividad>{

	Actividad findById(Integer id);
	
	//int save(Actividad dto, Double tarifa, List<Asignacion> asignaciones);
	int save(Actividad dto, Double tarifa);
	
	List<Actividad> findAllByActivityName(String name);
	
	List<Asignacion> findAsignacionByIdAct(Integer id);
	
	List<Actividad> listAllForBook();
	void update(Actividad actividad, List<Asignacion> listAsignacion, Double tarifa);

	
}
