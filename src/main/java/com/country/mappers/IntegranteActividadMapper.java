package com.country.mappers;

import com.country.common.DateFormater;
import com.country.form.IntegranteActividadForm;
import com.country.hibernate.model.IntegranteActividades;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class IntegranteActividadMapper {

	public static IntegranteActividades getIntegranteActividad(IntegranteActividadForm form)
			throws ParseException {

		IntegranteActividades dto = new IntegranteActividades();
		dto.setId(form.getId());
		dto.setActividad(form.getActividad());
		dto.setIntegrante(form.getIntegrante());
		dto.setFechaComienzo(DateFormater.convertStringToDate((form.getFechaIni())));
		dto.setFechaFin(DateFormater.convertStringToDate((form.getFechaFin())));
		return dto;

	}
	
	public static IntegranteActividadForm getForm(IntegranteActividades dto)
			throws ParseException {

		IntegranteActividadForm form =new IntegranteActividadForm();
		form.setId(dto.getId());
		form.setActividad(dto.getActividad());
		form.setIntegrante(dto.getIntegrante());
		form.setFechaIni(DateFormater.convertDateToString(dto.getFechaComienzo()));
		form.setFechaFin(DateFormater.convertDateToString(dto.getFechaFin()));
		return form;

	}

}
