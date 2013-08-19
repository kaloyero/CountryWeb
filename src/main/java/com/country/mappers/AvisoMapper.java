package com.country.mappers;

import com.country.common.DateUtil;
import com.country.form.AvisoForm;
import com.country.form.Form;
import com.country.hibernate.model.Aviso;
import com.country.hibernate.model.AvisoCategoria;
import com.country.hibernate.model.Persona;

public class AvisoMapper {

	public static Aviso getAviso(Form form) {
		
		Aviso dto = new Aviso();
		
		dto.setTittle(((AvisoForm) form).getTitulo());
		dto.setBody(((AvisoForm) form).getCuerpo());
		AvisoCategoria categoria = new AvisoCategoria();
		categoria.setId(((AvisoForm) form).getCategoria());
		dto.setCategoria(categoria);
		dto.setClose(((AvisoForm) form).getCierre());
		dto.setFecha(DateUtil.convertStringToDate(((AvisoForm) form).getFecha()));
		dto.setFechaFin(DateUtil.convertStringToDate(((AvisoForm) form).getFechaCierre()));
		dto.setHeader(((AvisoForm) form).getEncabezado());
		dto.setId(((AvisoForm) form).getId());
		Persona persona = new Persona();
		persona.setId(((AvisoForm) form).getPersona());
		dto.setPersona(persona);
		
		return dto;

	}

	public static Form getForm(Aviso dto) {
		AvisoForm form=new AvisoForm();

		form.setCategoria(dto.getCategoria().getId());
		form.setCategoriaDescription(dto.getCategoria().getNombre());
		form.setCierre(dto.getClose());
		form.setCuerpo(dto.getBody());
		form.setEncabezado(dto.getHeader());
		form.setFecha(DateUtil.convertDateToString(dto.getFecha()));
		form.setFechaCierre(DateUtil.convertDateToString(dto.getFechaFin()));
		form.setId(dto.getId());
		form.setPersona(dto.getPersona().getId());
		form.setPersonaNombre(dto.getPersona().getNombre() + " " + dto.getPersona().getApellido() + " - " + dto.getPersona().getTipoDoc().getNombre() + " " + dto.getPersona().getNroDoc());
		form.setTitulo(dto.getTittle());
		
		return form;
	}
	
}
