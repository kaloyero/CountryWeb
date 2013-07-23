package com.country.mappers;


import com.country.common.DateUtil;
import com.country.form.EventoForm;
import com.country.form.IntegranteForm;
import com.country.form.RecursoForm;
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
		dto.setHoraIni(form.getHoraIni());
		dto.setRecurso(form.getRecursoId());
		dto.setIntegrante(form.getIntegranteId());
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
	public static ReservaForm getForm(Reserva reserva,RecursoForm recurso,IntegranteForm integrante,EventoForm evento)
			throws ParseException {
		
		ReservaForm form=new ReservaForm();
		form.setId(reserva.getId());
		form.setFecha(DateUtil.convertDateToString(reserva.getFecha()));
		form.setDescripcion(reserva.getDescripcion());
		form.setDuracion(reserva.getDuracion());
		form.setHoraIni(reserva.getHoraIni());
		form.setRecursoId(reserva.getRecurso());
		form.setIntegranteId(reserva.getIntegrante());
		form.setEventoId(reserva.getEvento());
		
		return form;
	
	}

}
