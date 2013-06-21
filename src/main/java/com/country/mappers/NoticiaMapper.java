package com.country.mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.country.common.DateFormater;
import com.country.form.Form;
import com.country.form.MensajeForm;
import com.country.form.NoticiaForm;
import com.country.hibernate.model.Mensaje;
import com.country.hibernate.model.MensajeDetalles;
import com.country.hibernate.model.Noticia;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class NoticiaMapper {

	public static Noticia getNoticia(Form form)
			throws ParseException {
		
		Noticia	dto = new Noticia();
		dto.setId(form.getId());
		dto.setEstado(((NoticiaForm) form).getEstado());
		dto.setFecha(DateFormater.convertStringToDate(((NoticiaForm) form).getFecha()));
		//TODO AGREGAR NOTICIAS CATEGORIAS.
		dto.setFechaDesde(DateFormater.convertStringToDate(((NoticiaForm) form).getFechaDesde()));
		dto.setFechaHasta(DateFormater.convertStringToDate(((NoticiaForm) form).getFechaHasta()));
		dto.setTexto(((NoticiaForm) form).getTexto());
		dto.setTitulo(((NoticiaForm) form).getTitulo());
		
		return dto;
	
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
		form.setDetalles(getDetalles(detalles));
		
		return form;
	
	}
	
}
