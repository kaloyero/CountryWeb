package com.country.services;

import java.util.List;

import com.country.form.RecursoForm;
import com.country.hibernate.model.Recurso;

public interface ResourceManager extends AbstractManager<Recurso>{

	Recurso findById(Integer id);
	int save(RecursoForm form);
	
	RecursoForm getResourceForm(Integer id);
	
	void update(RecursoForm form);

	List<RecursoForm> listAllResourceForm();
	
}
