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
		return unidad;

	}

}
