package com.country.mappers;


import com.country.common.DateFormater;
import com.country.form.MensajeForm;
import com.country.hibernate.model.Integrante;
import com.country.hibernate.model.Mensaje;
import com.country.hibernate.model.MensajeCategorias;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class MensajeMapper {

	public static Mensaje getMensaje(MensajeForm form)
			throws ParseException {
		
		Mensaje	mensaje = new Mensaje();
		mensaje.setId(form.getId());
		mensaje.setAsunto(form.getAsunto());
		MensajeCategorias cat = new MensajeCategorias();
		cat.setId(form.getCategoria());
		mensaje.setCategoria(cat);
		mensaje.setEstado(form.getEstado());
		mensaje.setFecha(DateFormater.convertStringToDate((form.getFecha())));
		mensaje.setFechaCierre(DateFormater.convertStringToDate((form.getFechaCierre())));
		Integrante integ = new Integrante();
		integ.setId(form.getIntegrante());
		mensaje.setIntegrante(integ);
		mensaje.setResolucion(form.getResolucion());
		mensaje.setTipo(form.getTipo());
		
		return mensaje;
	
	}
	
	public static MensajeForm getForm(Mensaje mensaje)
			throws ParseException {
		
		MensajeForm form=new MensajeForm();
		form.setId(mensaje.getId());
		form.setAsunto(mensaje.getAsunto());
		form.setCategoria(mensaje.getCategoria().getId());
		form.setEstado(mensaje.getEstado());
		form.setFecha(DateFormater.convertDateToString(mensaje.getFecha()));
		form.setFechaCierre(DateFormater.convertDateToString(mensaje.getFechaCierre()));
		form.setIntegrante(mensaje.getIntegrante().getId());
		form.setIntegranteNombre(mensaje.getIntegrante().getUnidad().getCode() + " | " +
								mensaje.getIntegrante().getPersona().getNombre() + " " +
								mensaje.getIntegrante().getPersona().getApellido() + " " +
								mensaje.getIntegrante().getPersona().getTipoDoc().getNombre() + " " + 
								mensaje.getIntegrante().getPersona().getNroDoc() );
		form.setResolucion(mensaje.getResolucion());
		form.setTipo(mensaje.getTipo());

		return form;
	
	}

}
