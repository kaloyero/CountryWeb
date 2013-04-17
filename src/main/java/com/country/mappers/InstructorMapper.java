package com.country.mappers;

import com.country.common.DateFormater;
import com.country.form.InstructorForm;
import com.country.hibernate.model.Instructor;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class InstructorMapper {

	public static Instructor getInstructor(InstructorForm instructorForm)
			throws ParseException {
		
		Instructor instructor = new Instructor();
		instructor.setFechaComienzo(DateFormater.convertStringToDate(instructorForm.getFechaComienzo()));
		instructor.setFechaFin(DateFormater.convertStringToDate(instructorForm.getFechaFin()));
		instructor.setPersona(PersonaMapper.getPersona(instructorForm.getPersona()));
		instructor.setId(instructorForm.getId());
		return instructor;
	
	}
	
	public static InstructorForm getForm(Instructor instructor)
			throws ParseException {
		
		InstructorForm instructorForm=new InstructorForm();
		instructorForm.setId(instructor.getId());
		instructorForm.setPersona(PersonaMapper.getForm(instructor.getPersona()));
		instructorForm.setFechaComienzo(DateFormater.convertDateToString(instructor.getFechaComienzo()));
		instructorForm.setFechaFin(DateFormater.convertDateToString(instructor.getFechaFin()));
		return instructorForm;
	
	}



}
