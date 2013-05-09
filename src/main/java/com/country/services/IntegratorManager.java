package com.country.services;

import com.country.form.IntegranteForm;
import com.country.hibernate.model.Integrante;

public interface IntegratorManager extends AbstractManager<Integrante>{
	
	public IntegranteForm findById(Integer id);
	
	public void save(IntegranteForm form);
	
	public void update(IntegranteForm form);
	
	Integrante getActivitiesById(Integer id);
	
}
