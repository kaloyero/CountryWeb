package com.country.mappers;

import com.country.common.DateUtil;
import com.country.form.AvisoForm;
import com.country.form.Form;
import com.country.hibernate.model.Aviso;
import com.country.hibernate.model.AvisoCategoria;
import com.country.hibernate.model.Integrante;

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
		Integrante integrante = new Integrante();
		integrante.setId(((AvisoForm) form).getIntegrante());
		dto.setIntegrante(integrante);
		
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
		form.setIntegrante(dto.getIntegrante().getId());
		form.setIntegranteNombre(dto.getIntegrante().getPersona().getNombre() + " " + dto.getIntegrante().getPersona().getApellido() + " - " + dto.getIntegrante().getUnidad().getCode());
		form.setTitulo(dto.getTittle());
		
		return form;
	}
	
}
