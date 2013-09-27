package com.country.mappers;

import com.country.common.DateUtil;
import com.country.form.IntegranteActividadForm;
import com.country.hibernate.model.IntegranteActividades;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class IntegranteActividadMapper {

	public static IntegranteActividades getIntegranteActividad(IntegranteActividadForm form)
			throws ParseException {

		IntegranteActividades dto = new IntegranteActividades();
		dto.setId(form.getId());
		dto.setCronograma(form.getCronogramaId());
		dto.setActividad(form.getActividad().getId());
		dto.setIntegrante(form.getIntegranteId());
		dto.setFechaComienzo(DateUtil.convertStringToDate((form.getFechaIni())));
		dto.setFechaFin(DateUtil.convertStringToDate((form.getFechaFin())));
		return dto;

	}

	public static IntegranteActividadForm getForm(IntegranteActividades dto)
			throws ParseException {
				
				IntegranteActividadForm form =new IntegranteActividadForm();
				form.setId(dto.getId());
				form.setCronogramaId(dto.getCronograma());
				form.setActividadId(dto.getActividad());
				form.setIntegranteId (dto.getIntegrante());
				form.setFechaIni(DateUtil.convertDateToString(dto.getFechaComienzo()));
				form.setFechaFin(DateUtil.convertDateToString(dto.getFechaFin()));
				return form;
				
			}
	
}
