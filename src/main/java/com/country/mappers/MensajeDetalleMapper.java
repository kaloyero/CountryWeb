package com.country.mappers;

import java.util.Date;

import com.country.hibernate.model.MensajeDetalles;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class MensajeDetalleMapper {

	public static MensajeDetalles getMensajeDetalle(int mensajeId,String detalle,String modoMensaje)
			throws ParseException {
		
		MensajeDetalles	mensajeDetalle = new MensajeDetalles();
        mensajeDetalle.setMensaje(mensajeId);
        mensajeDetalle.setMensajeDetalle(detalle);
        mensajeDetalle.setFecha(new Date());
        mensajeDetalle.setModoMensaje(modoMensaje);
		
        return mensajeDetalle;
	
	}
	
}
