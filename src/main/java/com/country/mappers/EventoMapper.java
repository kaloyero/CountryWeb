package com.country.mappers;

import com.country.form.EventoForm;
import com.country.form.Form;
import com.country.hibernate.model.Evento;

public class EventoMapper {

	public static Evento getEvento(Form form) {
		
		Evento evento = new Evento();

		return evento;

	}
	

	public static Form getForm(Evento evento) {
		EventoForm form=new EventoForm();
		
	
		return form;
	}
	
}
