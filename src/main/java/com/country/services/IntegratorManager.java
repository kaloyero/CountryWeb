package com.country.services;

import java.util.Map;

import com.country.form.IntegranteForm;
import com.country.hibernate.model.Integrante;

public interface IntegratorManager extends AbstractManager<Integrante>{
	
	IntegranteForm findFormById(Integer id);
	
	void save(IntegranteForm form);
	
	void update(IntegranteForm form);
	
	Map<Integer, String> getIntegratorNames();
	
}
