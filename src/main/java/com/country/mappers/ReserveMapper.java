package com.country.mappers;


import com.country.common.DateUtil;
import com.country.form.ReservaForm;
import com.country.hibernate.model.Reserva;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class ReserveMapper {


	public static Reserva getReserva(ReservaForm form)
			throws ParseException {
		
		Reserva	dto = new Reserva();
		dto.setId(form.getId());
		dto.setDescripcion(form.getDescripcion());
		dto.setDuracion(form.getDuracion());
		dto.setFecha(DateUtil.convertStringToDate((form.getFecha())));
		dto.setHoraIni(DateUtil.getMinutes(form.getHoraIni(), form.getMinutosIni()));
		dto.setRecurso(form.getRecursoId());
		dto.setPersona(form.getPersonId());
		if (form.getEventoId()!=0 ){
			dto.setEvento(form.getEventoId());
		}
		return dto;
	
	}
	
	/** devuelve el formulario completo
	 * @param reserva
	 * @param recurso
	 * @param integrante
	 * @param evento
	 * @return
	 * @throws ParseException
	 */
	public static ReservaForm getForm(Reserva reserva)
			throws ParseException {
		
		ReservaForm form=new ReservaForm();
		form.setId(reserva.getId());
		form.setFecha(DateUtil.convertDateToString(reserva.getFecha()));
		form.setDescripcion(reserva.getDescripcion());
		form.setDuracion(reserva.getDuracion());
		form.setHoraIni(DateUtil.setHourInfForm(reserva.getHoraIni()));
		form.setMinutosIni(DateUtil.setMinutesInfForm(reserva.getHoraIni()));
		form.setRecursoId(reserva.getRecurso());
		form.setPersonId(reserva.getPersona());
		form.setEventoId(reserva.getEvento());
		
		return form;
	
	}

}
