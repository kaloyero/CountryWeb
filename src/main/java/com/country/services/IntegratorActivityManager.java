package com.country.services;

import java.util.List;

import com.country.form.IntegranteActividadForm;
import com.country.hibernate.model.IntegranteActividades;

public interface IntegratorActivityManager extends AbstractManager<IntegranteActividades>{
	
	public IntegranteActividadForm findById(Integer id);
	
	public void save(IntegranteActividadForm form);
	
	public List<IntegranteActividades> findAllByActivityIntegrator(String name);
	
}
