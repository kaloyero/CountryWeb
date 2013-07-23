package com.country.services;

import java.util.List;

import com.country.form.ActividadForm;
import com.country.form.IntegranteActividadForm;
import com.country.form.IntegranteForm;
import com.country.hibernate.model.IntegranteActividades;

public interface IntegratorActivityManager extends AbstractManager<IntegranteActividades>{
	
	IntegranteActividadForm findFormById(Integer id);
	
	
	/**
	 * Inscribir el integrante a una actividad
	 * 
	 * @param integrante
	 * @param actividad
	 * @param fechaIni
	 * @param fechaFin
	 */
	void inscribirse(int integrante,int actividad,String fechaIni,String fechaFin);
	
	/**
	 * Inscribir el integrante a una actividad
	 * 
	 * @param form
	 */
	void inscribirse(IntegranteActividadForm form);

	void update(IntegranteActividadForm form);
	
	public List<IntegranteForm> findAllIntegrantorFormByActivityId(Integer id);
	
	public List<ActividadForm> findAllActivitiesByIntegratorId(Integer id);
	
}
