package com.country.mappers;

import java.util.Date;

import com.country.form.Form;
import com.country.form.PersonaForm;
import com.country.hibernate.model.Persona;

public class PersonaMapper {

	public static Persona getPersona(Form form) {
		
		Persona persona = new Persona();
		persona.setApellido(((PersonaForm) form).getApellido());
		persona.setDtNacimiento(new Date(2012, 12, 12));
		persona.setEmail(((PersonaForm) form).getEmail());
		persona.setNombre(((PersonaForm) form).getNombre());
		persona.setNroDoc(((PersonaForm) form).getNroDoc());
		persona.setSexo(((PersonaForm) form).getSexo());
		return persona;

	}

	public Object getForm(Object object) {
		// TODO Auto-generated method stub
		return null;
	}


}
