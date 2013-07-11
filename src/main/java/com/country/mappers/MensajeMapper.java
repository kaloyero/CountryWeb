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

public class MensajeMapper {

	public static Mensaje getMensaje(MensajeForm form)
			throws ParseException {
		
		Mensaje	mensaje = new Mensaje();
		mensaje.setId(form.getId());
		mensaje.setAsunto(form.getAsunto());
		MensajeCategorias cat = new MensajeCategorias();
		cat.setId(form.getCategoria());
		mensaje.setCategoria(cat);
		//Si el estado esta vacio,es un nuevo Mensaje(Reclamo),Esto calculardo en el servicio
		 if (form.getEstado()!=null){
			 mensaje.setEstado(form.getEstado());

		 }else{
			 mensaje.setEstado("A");

		 }
		
		mensaje.setFecha(new Date());
		if (form.getFechaCierre()!=null)
			mensaje.setFechaCierre(DateFormater.convertStringToDate((form.getFechaCierre())));
		Integrante integ = new Integrante();
		integ.setId(form.getIntegrante());
		mensaje.setIntegrante(integ);
		mensaje.setResolucion("X");
		//Si es Reclamo va Ro,sino M
		//mensaje.setTipo("R");
		//mensaje.setTipo(form.getTipo());
		
		return mensaje;
	
	}
	
	public static MensajeForm getForm(Mensaje mensaje,List<MensajeDetalles> detalles)
			throws ParseException {
		
		MensajeForm form=new MensajeForm();
		form.setId(mensaje.getId());
		form.setAsunto(mensaje.getAsunto());
		form.setCategoria(mensaje.getCategoria().getId());
		form.setEstado(mensaje.getEstado());
		form.setFecha(DateFormater.convertDateToString(mensaje.getFecha()));
		form.setFechaCierre(DateFormater.convertDateToString(mensaje.getFechaCierre()));
		//OJO ,el integrante puede ser nulo
		form.setIntegrante(mensaje.getIntegrante().getId());
		form.setIntegranteNombre(mensaje.getIntegrante().getUnidad().getCode() + " | " +
								mensaje.getIntegrante().getPersona().getNombre() + " " +
								mensaje.getIntegrante().getPersona().getApellido() + " " +
								mensaje.getIntegrante().getPersona().getTipoDoc().getNombre() + " " + 
								mensaje.getIntegrante().getPersona().getNroDoc() );
		form.setResolucion(mensaje.getResolucion());

		form.setDetalles(getDetalles(detalles));
		form.setTipo(mensaje.getTipo());
		
		return form;
	
	}

	private static Map<Integer, String> getDetalles(List<MensajeDetalles> detalles) {
		Map<Integer, String> lista = new HashMap<Integer, String>();
		for (MensajeDetalles msjDet : detalles) {
			lista.put(msjDet.getId(), msjDet.getMensajeDetalle());
		}
		
		return lista;
	}

	
}
