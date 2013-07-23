package com.country.mappers;

import java.util.List;

import com.country.common.DateUtil;
import com.country.form.InstructorForm;
import com.country.hibernate.model.Direccion;
import com.country.hibernate.model.Instructor;
import com.country.hibernate.model.Telefono;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class InstructorMapper {

	public static Instructor getInstructor(InstructorForm instructorForm)
			throws ParseException {
		
		Instructor instructor = new Instructor();
		instructor.setFechaComienzo(DateUtil.convertStringToDate(instructorForm.getFechaComienzo()));
		instructor.setFechaFin(DateUtil.convertStringToDate(instructorForm.getFechaFin()));
		instructor.setPersona(PersonaMapper.getPersona(instructorForm.getPersona()));
		instructor.setId(instructorForm.getId());
		return instructor;
	
	}
	
	public static InstructorForm getForm(Instructor instructor,List<Telefono> tels,List<Direccion> dirs)
			throws ParseException {
		
		InstructorForm instructorForm=new InstructorForm();
		instructorForm.setId(instructor.getId());
		instructorForm.setPersona(PersonaMapper.getForm(instructor.getPersona(), dirs, tels));
		instructorForm.setFechaComienzo(DateUtil.convertDateToString(instructor.getFechaComienzo()));
		instructorForm.setFechaFin(DateUtil.convertDateToString(instructor.getFechaFin()));
		return instructorForm;
	
	}
}
