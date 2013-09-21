package com.country.services;

import java.util.List;

import com.country.form.EventoForm;
import com.country.hibernate.model.Evento;

public interface EventManager extends AbstractManager<Evento>{

	EventoForm findFormById(Integer id);
	
	public void save(EventoForm form);
	
	public void update(EventoForm form);

	public List<EventoForm> listAllForms();
}
