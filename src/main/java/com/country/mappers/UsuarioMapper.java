package com.country.mappers;

import com.country.common.DateUtil;
import com.country.common.MapperUtil;
import com.country.form.UsuarioForm;
import com.country.hibernate.model.Usuario;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class UsuarioMapper {

	public static Usuario getUsuario(UsuarioForm form)
			throws ParseException {

		Usuario entity = new Usuario();
		entity.setId(form.getId());
		entity.setClave(form.getClave());
		entity.setDescripcion(form.getDescripcion());
		entity.setNombreUsuario(form.getUsuario());
		entity.setEstado(MapperUtil.getStatusEntity(form.isEstado()));
		entity.setFechaDesde(DateUtil.convertStringToDate(form.getFechaCreacion()));
		entity.setFechaHasta(DateUtil.convertStringToDate(form.getFechaCaduca()));
		
		return entity;

	}
	
	public static UsuarioForm getForm(Usuario entity)
			throws ParseException {

		UsuarioForm form=new UsuarioForm();
		form.setId(entity.getId());
		form.setUsuario(entity.getNombreUsuario());
		form.setEstado(MapperUtil.getStatusForm(entity.getEstado()));
		form.setFechaCaduca(DateUtil.convertDateToString(entity.getFechaDesde()));
		form.setFechaCreacion(DateUtil.convertDateToString(entity.getFechaHasta()));
		form.setUsuario(entity.getNombreUsuario());
		return form;

	}

}
