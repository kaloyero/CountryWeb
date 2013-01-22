package com.country.mappers;


import com.country.form.IntegranteForm;
import com.country.hibernate.model.Integrante;
import com.country.hibernate.model.Unidad;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class IntegranteMapper {



	public static Integrante getIntegrante(IntegranteForm integranteForm)
			throws ParseException {
		
		Integrante integrante = new Integrante();
		Unidad unidad =new Unidad();
		unidad.setId(integranteForm.getUnidad());
		integrante.setUnidad(unidad);
		integrante.setTipo("T");
		integrante.setPersona(PersonaMapper.getPersona(integranteForm.getPersona()));
		return integrante;
	
	}



}
