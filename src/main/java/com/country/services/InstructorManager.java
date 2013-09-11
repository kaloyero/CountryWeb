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
	
	/**
	 * Devuelve todos los instructores Activos o los inactivos segun el valor del parametro 'active'
	 * 
	 * @param active
	 * @return
	 */
	public List<Instructor> listAll(boolean active);
	
	public List<InstructorForm> listAllFormsComplete();
	
	public List<InstructorForm> listAllFormsComplete(boolean active);
	
}
