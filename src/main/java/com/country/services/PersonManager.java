package com.country.services;

import com.country.form.PersonaForm;
import com.country.hibernate.model.Persona;

public interface PersonManager extends AbstractManager<Persona>{
	
	PersonaForm findFormById(Integer id);

}
