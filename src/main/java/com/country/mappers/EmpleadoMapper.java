package com.country.mappers;

import java.util.List;

import com.country.common.DateUtil;
import com.country.common.MapperUtil;
import com.country.form.EmpleadoForm;
import com.country.hibernate.model.Direccion;
import com.country.hibernate.model.Empleado;
import com.country.hibernate.model.EmpleadoCategoria;
import com.country.hibernate.model.Telefono;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class EmpleadoMapper {

	public static Empleado getEmpleado(EmpleadoForm form)
			throws ParseException {

		Empleado emp = new Empleado();
		emp.setId(form.getId());
			EmpleadoCategoria categoria = new EmpleadoCategoria();
			categoria.setId(form.getId());
		emp.setCategoria(categoria);
		emp.setFecha(DateUtil.convertStringToDate(form.getFecha()));
		emp.setLegajo(form.getLegajo());
		emp.setPuesto(form.getPuesto());
		emp.setEstado(MapperUtil.getStatusEntity(form.isEstado()));
		emp.setPersona(PersonaMapper.getPersona(form.getPersona()));
		emp.setUsuario(UsuarioMapper.getUsuario(form.getUsuario()));
		
		return emp;

	}
	
	public static EmpleadoForm getForm(Empleado emp,List<Telefono> tels,List<Direccion> dires)
			throws ParseException {

		EmpleadoForm form=new EmpleadoForm();
		form.setId(emp.getId());
		form.setPersona(PersonaMapper.getForm(emp.getPersona(), dires, tels));
		form.setUsuario(UsuarioMapper.getForm(emp.getUsuario()));
		form.setEstado(MapperUtil.getStatusForm(emp.getEstado()));
		form.setLegajo(emp.getLegajo());
		form.setPuesto(emp.getPuesto());
		form.setIdCategoria(emp.getCategoria().getId());
		form.setFecha(DateUtil.convertDateToString(emp.getFecha()));
		
		return form;

	}

}
