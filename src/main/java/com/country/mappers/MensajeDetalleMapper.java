package com.country.mappers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.country.common.DateFormater;
import com.country.form.MensajeForm;
import com.country.hibernate.model.Integrante;
import com.country.hibernate.model.Mensaje;
import com.country.hibernate.model.MensajeCategorias;
import com.country.hibernate.model.MensajeDetalles;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class MensajeDetalleMapper {

	public static MensajeDetalles getMensajeDetalle(int mensajeId,String detalle)
			throws ParseException {
		
		MensajeDetalles	mensajeDetalle = new MensajeDetalles();
        mensajeDetalle.setMensaje(mensajeId);
        mensajeDetalle.setMensajeDetalle(detalle);
        mensajeDetalle.setFecha(new Date());
        //Si es un mensaje de propietario E,sino S
        mensajeDetalle.setModoMensaje("R");
		return mensajeDetalle;
	
	}
	
}
