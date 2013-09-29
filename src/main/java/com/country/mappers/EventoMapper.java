package com.country.mappers;

import com.country.common.DateUtil;
import com.country.common.MapperUtil;
import com.country.form.EventoForm;
import com.country.form.Form;
import com.country.form.ReservaForm;
import com.country.hibernate.model.Evento;
import com.country.hibernate.model.Persona;
import com.country.hibernate.model.Reserva;
import com.country.hibernate.model.Tarifa;

public class EventoMapper {

	public static Evento getEvento(Form form) {
		
		Evento evento = new Evento();
		evento.setId(((EventoForm) form).getId());
		
		if ((((EventoForm) form)).getConcepto() != null) {
			((EventoForm) form).getConcepto().setFechaComienzo(((EventoForm) form).getFecha());
			((EventoForm) form).getConcepto().setNombre(((EventoForm) form).getNombre());
			evento.setConcepto(ConceptoMapper.getConcepto(((EventoForm) form).getConcepto()));
		}
		
		
		evento.setDescription(((EventoForm) form).getDescripcion());
		evento.setHourIni(((EventoForm) form).getHourIni());
		evento.setDuracion(((EventoForm) form).getDuracion());
		evento.setCupo(((EventoForm) form).getCupo());
		evento.setFecha(DateUtil.convertStringToDate(((EventoForm) form).getFecha()));
		evento.setHourIni(DateUtil.getMinutes(((EventoForm) form).getHourIni(), ((EventoForm) form).getMinutesIni()));
		evento.setNombre(((EventoForm) form).getNombre());
		Persona persona = new Persona();
		persona.setId(((EventoForm) form).getPersonaId());
		evento.setPersona(persona);
		
		return evento;

	}
	

	public static Form getForm(Evento evento, Tarifa tarifa,Reserva reserva) {
		EventoForm form=new EventoForm();
		if (tarifa != null) {
			form.setConcepto(ConceptoMapper.getForm(evento.getConcepto(),tarifa));
		}
		form.setCupo(evento.getCupo());
		form.setDescripcion(evento.getDescription());
		form.setFecha(DateUtil.convertDateToString(evento.getFecha()));
		form.setDuracion(evento.getDuracion());
		form.setHourIni(DateUtil.setHourInfForm((evento.getHourIni())));
		form.setMinutesIni(DateUtil.setMinutesInfForm((evento.getHourIni())));
		form.setId(evento.getId());
		form.setNombre(evento.getNombre());
		form.setPersona(PersonaMapper.getForm(evento.getPersona(), null, null));
		form.setDiaSemana(DateUtil.getDiaDeLaSemanaName(evento.getFecha()));
		form.setDescripcion(evento.getDescription());
		form.setPersona(PersonaMapper.getForm(evento.getPersona(), null, null));
		form.setPersonaId(evento.getPersona().getId());
		form.setEnvioAdm(MapperUtil.getStatusUserForm(evento.getPersona().getTipo()));
		if (reserva != null){
			ReservaForm reservaform = new ReservaForm();
			reservaform.setId(reserva.getId());
			reservaform.setRecursoId(reserva.getRecurso());
			reservaform.setFecha(DateUtil.convertDateToString(reserva.getFecha()));
			reservaform.setDuracion(reserva.getDuracion());
			reservaform.setHoraIni(DateUtil.setHourInfForm((reserva.getHoraIni())));
			reservaform.setMinutosIni(DateUtil.setMinutesInfForm((reserva.getHoraIni())));
			form.setReserva(reservaform);
		}
		
		return form;
	}
	
}
