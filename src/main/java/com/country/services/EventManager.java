package com.country.services;

import com.country.form.EventoForm;
import com.country.hibernate.model.Evento;

public interface EventManager extends AbstractManager<Evento>{

	EventoForm findFormById(Integer id);
	
	public void save(EventoForm form);
	
	public void update(EventoForm form);
	
}
