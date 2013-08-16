package com.country.mappers;

import com.country.common.DateUtil;
import com.country.hibernate.model.MensajeDetalles;
import com.country.hibernate.model.Persona;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class MensajeDetalleMapper {

	public static MensajeDetalles getMensajeDetalle(int mensajeId,String detalle,String modoMensaje,int idPersona)
			throws ParseException {
		
		MensajeDetalles	mensajeDetalle = new MensajeDetalles();
        mensajeDetalle.setMensaje(mensajeId);
        mensajeDetalle.setMensajeDetalle(detalle);
        mensajeDetalle.setFecha(DateUtil.getDateToday());
        mensajeDetalle.setModoMensaje(modoMensaje);
        Persona persona = new Persona();
        persona.setId(idPersona);
        mensajeDetalle.setPersona(persona);
        return mensajeDetalle;
	
	}
	
}
