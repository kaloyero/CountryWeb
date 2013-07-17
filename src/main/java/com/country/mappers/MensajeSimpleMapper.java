package com.country.mappers;

import java.util.List;

import com.country.form.MensajeForm;
import com.country.hibernate.model.Mensaje;
import com.country.hibernate.model.MensajeDetalles;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class MensajeSimpleMapper {

	public static Mensaje getMensaje(MensajeForm form)
			throws ParseException {
		
		Mensaje	mensaje = MensajeMapper.getMensaje(form);
		mensaje.setTipo("M");
		return mensaje;
	
	}
	
	public static MensajeForm getForm(Mensaje mensaje,List<MensajeDetalles> detalles){
		 MensajeForm form=MensajeMapper.getForm(mensaje);
		return form;
}

	
}
