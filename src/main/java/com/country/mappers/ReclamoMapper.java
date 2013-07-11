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

public class ReclamoMapper {

	public static Mensaje getMensaje(MensajeForm form)
			throws ParseException {
		
		Mensaje	mensaje = MensajeMapper.getMensaje(form);
		mensaje.setTipo("R");
		return mensaje;
	
	}
	
	public static MensajeForm getForm(Mensaje mensaje,List<MensajeDetalles> detalles){
		 MensajeForm form=MensajeMapper.getForm(mensaje, detalles);
		return form;
}

	
}
