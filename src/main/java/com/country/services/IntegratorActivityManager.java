package com.country.services;

import java.util.List;

import com.country.form.ActividadForm;
import com.country.form.IntegranteActividadForm;
import com.country.form.IntegranteForm;
import com.country.hibernate.model.IntegranteActividades;

public interface IntegratorActivityManager extends AbstractManager<IntegranteActividades>{
	
	IntegranteActividadForm findFormById(Integer id);
	
	void save(IntegranteActividadForm form); 
	
	void update(IntegranteActividadForm form);
	
	public List<IntegranteForm> findAllIntegrantorFormByActivityId(Integer id);
	
	public List<ActividadForm> findAllActivitiesByIntegratorId(Integer id);
	
}
