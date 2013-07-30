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
		if ((((EventoForm) form)).getConcepto() != null) {
			((EventoForm) form).getConcepto().setFechaComienzo(((EventoForm) form).getFecha());
			evento.setConcepto(ConceptoMapper.getConcepto(((EventoForm) form).getConcepto()));
		}
		
		
		evento.setDescription(((EventoForm) form).getDescripcion());
		evento.setHourIni(((EventoForm) form).getHourIni());
		evento.setDuracion(((EventoForm) form).getDuracion());
		evento.setCupo(((EventoForm) form).getCupo());
		evento.setFecha(DateUtil.convertStringToDate(((EventoForm) form).getFecha()));
		evento.setHourIni(((EventoForm) form).getHourIni());
		evento.setNombre(((EventoForm) form).getNombre());
		
		Integrante integrante = new Integrante();
		integrante.setId(((EventoForm) form).getIntegrante());
		evento.setIntegrante(integrante);
		
		return evento;

	}
	

	public static Form getForm(Evento evento, Tarifa tarifa) {
		EventoForm form=new EventoForm();
		if ((evento.getConcepto() != null)) {
			form.setConcepto(ConceptoMapper.getForm(evento.getConcepto(),tarifa));
		}
		form.setCupo(evento.getCupo());
		form.setDescripcion(evento.getDescription());
		form.setFecha(DateUtil.convertDateToString(evento.getFecha()));
		form.setDuracion(evento.getDuracion());
		form.setHourIni(evento.getHourIni());
		form.setId(evento.getId());
		form.setNombre(evento.getNombre());
		if (evento.getIntegrante() != null){
			form.setIntegrante(evento.getIntegrante().getId());	
			form.setIntegranteApellido(evento.getIntegrante().getPersona().getApellido());
			form.setIntegranteNombre(evento.getIntegrante().getPersona().getNombre());

		}
		form.setDiaSemana(DateUtil.getDiaDeLaSemanaName(evento.getFecha()));
		form.setDescripcion(evento.getDescription());
		
		//form.setRecurso(evento.get);
		
		return form;
	}
	
}
