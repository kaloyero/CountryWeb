package com.country.mappers;

import com.country.common.DateUtil;
import com.country.form.EventoForm;
import com.country.form.Form;
import com.country.hibernate.model.Evento;
import com.country.hibernate.model.Integrante;
import com.country.hibernate.model.Tarifa;

public class EventoMapper {

	public static Evento getEvento(Form form) {
		
		Evento evento = new Evento();
		evento.setId(((EventoForm) form).getId());
		
		((EventoForm) form).getConcepto().setFechaComienzo(((EventoForm) form).getFecha());
		evento.setConcepto(ConceptoMapper.getConcepto(((EventoForm) form).getConcepto()));
		
		evento.setDescription(((EventoForm) form).getDescripcion());
		evento.setHourIni(((EventoForm) form).getHourIni());
		evento.setDuracion(((EventoForm) form).getDuracion());
		evento.setCupo(((EventoForm) form).getCupo());
		evento.setFecha(DateUtil.convertStringToDate(((EventoForm) form).getFecha()));
		evento.setHourIni(((EventoForm) form).getHourIni());
		
		Integrante integrante = new Integrante();
		integrante.setId(((EventoForm) form).getIntegrante());
		evento.setIntegrante(integrante);
		
		return evento;

	}
	

	public static Form getForm(Evento evento, Tarifa tarifa) {
		EventoForm form=new EventoForm();
		
		form.setConcepto(ConceptoMapper.getForm(evento.getConcepto(),tarifa));
		form.setCupo(evento.getCupo());
		form.setDescripcion(evento.getDescription());
		form.setFecha(DateUtil.convertDateToString(evento.getFecha()));
		form.setDuracion(evento.getDuracion());
		form.setHourIni(evento.getHourIni());
		form.setId(evento.getId());
		if (evento.getIntegrante() != null){
			form.setIntegrante(evento.getIntegrante().getId());	
		}
		
		//form.setRecurso(evento.get);
		
		return form;
	}
	
}
