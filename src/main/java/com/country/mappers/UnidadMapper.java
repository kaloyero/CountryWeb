package com.country.mappers;

import com.country.form.UnidadForm;
import com.country.hibernate.model.Emprendimiento;
import com.country.hibernate.model.Unidad;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class UnidadMapper {

	public static Unidad getUnidad(UnidadForm unidadForm) throws ParseException {

		Unidad unidad = new Unidad();
		unidad.setCode(unidadForm.getCode());
		unidad.setDescription(unidadForm.getDescripcion());
		Emprendimiento emp =new Emprendimiento();
		emp.setId(1);
		unidad.setBusiness(emp);
		unidad.setId(unidadForm.getId());
		return unidad;

	}
	
	public static UnidadForm getForm(Unidad unidad) throws ParseException {

		UnidadForm form = new UnidadForm();
		form.setCode(unidad.getCode());
		form.setDescripcion(unidad.getDescription());
		form.setId(unidad.getId());
		return form;

	}

}
