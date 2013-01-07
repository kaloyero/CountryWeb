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
		return instructor;
	
	}



}
