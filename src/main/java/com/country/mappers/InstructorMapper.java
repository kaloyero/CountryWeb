package com.country.mappers;

import java.util.Date;

import com.country.form.InstructorForm;
import com.country.hibernate.model.Instructor;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class InstructorMapper {

	public static Instructor getInstructor(InstructorForm instructorForm)
			throws ParseException {
		
		Instructor instructor = new Instructor();
		instructor.setFechaComienzo(new Date(2012, 12, 12));
		instructor.setFechaFin(new Date(2012, 12, 12));
		instructor.setPersona(PersonaMapper.getPersona(instructorForm.getPersona()));
		instructor.setId(instructorForm.getId());
		return instructor;
	
	}
	
	public static InstructorForm getForm(Instructor instructor)
			throws ParseException {
		
		InstructorForm instructorForm=new InstructorForm();
		instructorForm.setId(instructor.getId());
		instructorForm.setPersona(PersonaMapper.getForm(instructor.getPersona()));
		instructorForm.setFechaComienzo(instructor.getFechaComienzo());
		instructorForm.setFechaFin(instructor.getFechaFin());
		return instructorForm;
	
	}



}
