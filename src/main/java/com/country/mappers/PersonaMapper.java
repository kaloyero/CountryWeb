package com.country.mappers;

import java.util.Date;

import com.country.form.PersonaForm;
import com.country.hibernate.model.Persona;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class PersonaMapper {

	public static Persona getPersona(PersonaForm personaForm)
			throws ParseException {

		Persona persona = new Persona();
		persona.setApellido(personaForm.getApellido());
		persona.setDtNacimiento(new Date(2012, 12, 12));
		persona.setEmail(personaForm.getEmail());
		persona.setNombre(personaForm.getNombre());
		persona.setNroDoc(personaForm.getNroDoc());
		persona.setSexo(personaForm.getSexo());
		return persona;

	}

}
