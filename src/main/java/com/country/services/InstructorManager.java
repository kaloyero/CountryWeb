package com.country.services;

import java.util.List;

import com.country.form.InstructorForm;
import com.country.form.TipoForm;
import com.country.hibernate.model.Instructor;

public interface InstructorManager extends AbstractManager<Instructor>{

	public Instructor findById(Integer id);
	
	InstructorForm findFormById(Integer id);
	
	void save(InstructorForm form);
	
	void update(InstructorForm form);
	
	List<TipoForm> getIntegratorNames();
}
