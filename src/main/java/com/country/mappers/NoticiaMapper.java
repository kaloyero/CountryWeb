package com.country.mappers;

import com.country.common.DateFormater;
import com.country.form.Form;
import com.country.form.NoticiaForm;
import com.country.hibernate.model.Noticia;
import com.country.hibernate.model.NoticiaCategorias;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class NoticiaMapper {

	public static Noticia getNoticia(Form form)
			throws ParseException {
		
		Noticia	dto = new Noticia();
		dto.setId(((NoticiaForm) form).getId());
		dto.setEstado(((NoticiaForm) form).getEstado());
		dto.setFecha(DateFormater.convertStringToDate(((NoticiaForm) form).getFecha()));
		NoticiaCategorias notCat = new NoticiaCategorias();
		notCat.setId(((NoticiaForm) form).getCategoria());
		dto.setCategoria(notCat);
		dto.setFechaDesde(DateFormater.convertStringToDate(((NoticiaForm) form).getFechaDesde()));
		dto.setFechaHasta(DateFormater.convertStringToDate(((NoticiaForm) form).getFechaHasta()));
		dto.setTexto(((NoticiaForm) form).getTexto());
		dto.setTitulo(((NoticiaForm) form).getTitulo());
		
		return dto;
	
	}
	
	public static NoticiaForm getForm(Noticia dto)
			throws ParseException {
		
		NoticiaForm form=new NoticiaForm();
		form.setId(dto.getId());
		form.setCategoria(dto.getCategoria().getId());
		form.setEstado(dto.getEstado());
		form.setFecha(DateFormater.convertDateToString(dto.getFecha()));
		form.setFechaDesde(DateFormater.convertDateToString(dto.getFechaDesde()));
		form.setFechaHasta(DateFormater.convertDateToString(dto.getFechaHasta()));
		form.setTexto(dto.getTexto());
		form.setTitulo(dto.getTitulo());
		
		return form;
	
	}
	
}
