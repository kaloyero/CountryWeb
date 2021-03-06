package com.country.mappers;

import java.util.List;

import com.country.common.MapperUtil;
import com.country.form.IntegranteForm;
import com.country.hibernate.model.Integrante;
import com.country.hibernate.model.Telefono;
import com.country.hibernate.model.Unidad;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class IntegranteMapper {

	public static Integrante getIntegrante(IntegranteForm integranteForm)
			throws ParseException {

		Integrante integrante = new Integrante();
		Unidad unidad =new Unidad();
		unidad.setId(integranteForm.getUnidad());
		integrante.setId(integranteForm.getId());
		integrante.setUnidad(unidad);
		integrante.setTipo("T");
		integrante.setEstado(MapperUtil.getStatusEntity(integranteForm.isEstado()));
		integrante.setPersona(PersonaMapper.getPersona(integranteForm.getPersona()));
		integrante.setUsuario(UsuarioMapper.getUsuario(integranteForm.getUsuario()));
		
		return integrante;

	}
	
	public static IntegranteForm getForm(Integrante integrante,List<Telefono> tels)
			throws ParseException {

		IntegranteForm integranteForm=new IntegranteForm();
		integranteForm.setId(integrante.getId());
		integranteForm.setPersona(PersonaMapper.getForm(integrante.getPersona(), null, tels));
		integranteForm.setUsuario(UsuarioMapper.getForm(integrante.getUsuario()));
		integranteForm.setUnidad(integrante.getUnidad().getId());
		integranteForm.setUnidadCode(integrante.getUnidad().getCode());
		integranteForm.setEstado(MapperUtil.getStatusForm(integrante.getEstado()));
		return integranteForm;

	}

}
