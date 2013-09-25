package com.country.services;

import java.util.List;

import com.country.form.InfraccionForm;
import com.country.hibernate.model.Infraccion;

public interface InfractionManager extends AbstractManager<Infraccion>{
	
	InfraccionForm findFormById(Integer id);
	
	void save(InfraccionForm form);
	
	void update(InfraccionForm form);
	
	public List<InfraccionForm> listAllForms();
	
	Integer getNumInfraccionesByUnidad();

}
