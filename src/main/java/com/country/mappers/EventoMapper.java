package com.country.mappers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.country.common.DateFormater;
import com.country.form.EventoForm;
import com.country.form.Form;
import com.country.form.NoticiaForm;
import com.country.hibernate.model.Emprendimiento;
import com.country.hibernate.model.Evento;
import com.country.hibernate.model.Unidad;

public class EventoMapper {

	public static Evento getEvento(Form form) throws ParseException {
		
		Evento evento = new Evento();
		evento.setDescription(((EventoForm) form).getDescripcion());
		evento.setHourIni(((EventoForm) form).getHourIni());
		
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		evento.setNombre(((EventoForm) form).getNombre());
		evento.setFecha((Date) formatter.parse(((EventoForm) form).getFecha()) );

		return evento;

	}
	

	public static Form getForm(Evento evento) {
		EventoForm form=new EventoForm();
		
	
		return form;
	}
	
}
