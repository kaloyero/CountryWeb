package com.country.mappers;


import com.country.form.EventoForm;
import com.country.form.EventoIntegranteForm;
import com.country.form.IntegranteForm;
import com.country.form.RecursoForm;
import com.country.form.ReservaForm;
import com.country.hibernate.model.EventoIntegrante;
import com.country.hibernate.model.Reserva;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class EventoIntegranteMapper {


	public static EventoIntegrante getEventoIntegrante(EventoIntegranteForm form)
			throws ParseException {
		
		EventoIntegrante entidad = new EventoIntegrante();
		entidad.setEvento(form.getEvento());
		entidad.setIntegrante(form.getIntegrante());
		return entidad;
	
	}
	
	/** devuelve el formulario completo
	 * @param reserva
	 * @param recurso
	 * @param integrante
	 * @param evento
	 * @return
	 * @throws ParseException
	 */
	public static EventoIntegranteForm getForm(EventoIntegrante eventoIntegrante)
			throws ParseException {
		
		EventoIntegranteForm form=new EventoIntegranteForm();
		form.setId(eventoIntegrante.getId());
		form.setIntegrante(eventoIntegrante.getIntegrante());
		form.setEvento(eventoIntegrante.getEvento());

		
		return form;
	
	}

}
