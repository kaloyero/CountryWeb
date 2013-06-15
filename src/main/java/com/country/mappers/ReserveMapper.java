package com.country.mappers;

import com.country.common.DateFormater;
import com.country.form.EventoForm;
import com.country.form.IntegranteForm;
import com.country.form.RecursoForm;
import com.country.form.ReservaForm;
import com.country.hibernate.model.Evento;
import com.country.hibernate.model.Recurso;
import com.country.hibernate.model.Reserva;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class ReserveMapper {

	public static Reserva getReserva(ReservaForm form)
			throws ParseException {
		
		Reserva	dto = new Reserva();
		dto.setId(form.getId());
		dto.setDescripcion(form.getDescripcion());
		dto.setDuracion(form.getDuracion());
		dto.setFecha(DateFormater.convertStringToDate((form.getFecha())));
		dto.setHoraIni(form.getHoraIni());
		
		Recurso recurso = new Recurso();
		recurso.setId(form.getRecurso().getId());
		dto.setRecurso(recurso);

		dto.setIntegrante(form.getIntegrante().getId());

		Evento evento= new Evento();
		evento.setId(form.getEvento().getId());
		dto.setEvento(evento);

		return dto;
	
	}
	
	public static ReservaForm getForm(Reserva reserva,RecursoForm recurso,IntegranteForm integrante,EventoForm evento)
			throws ParseException {
		
		ReservaForm form=new ReservaForm();
		form.setId(reserva.getId());
		form.setFecha(DateFormater.convertDateToString(reserva.getFecha()));
		form.setDescripcion(reserva.getDescripcion());
		form.setDuracion(reserva.getDuracion());
		form.setHoraIni(reserva.getHoraIni());
		form.setRecurso(recurso);
		form.setIntegrante(integrante);
		form.setEvento(evento);
		
		return form;
	
	}
	
}
