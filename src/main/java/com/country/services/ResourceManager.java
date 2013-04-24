package com.country.services;

import com.country.form.RecursoForm;
import com.country.hibernate.model.Recurso;

public interface ResourceManager extends AbstractManager<Recurso>{

	Recurso findById(Integer id);
	int save(Recurso dto,double tarifa);
	
	RecursoForm getResourceForm(Integer id);
	
	void update(RecursoForm form);
	
}
