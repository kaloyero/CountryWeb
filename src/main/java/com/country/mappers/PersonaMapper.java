package com.country.mappers;

import java.text.Format;
import java.text.SimpleDateFormat;

import com.country.common.DateFormater;
import com.country.form.Form;
import com.country.form.PersonaForm;
import com.country.hibernate.model.Persona;
import com.country.hibernate.model.TipoDocumento;

public class PersonaMapper {

	public static Persona getPersona(Form form) {
		
		Persona persona = new Persona();
		persona.setApellido(((PersonaForm) form).getApellido());
		persona.setDtNacimiento(DateFormater.convertStringToDate(((PersonaForm) form).getNacimiento()));
		persona.setEmail(((PersonaForm) form).getEmail());
		persona.setNombre(((PersonaForm) form).getNombre());
		persona.setNroDoc(((PersonaForm) form).getNroDoc());
		persona.setSexo(((PersonaForm) form).getSexo());
		//TODO
//REEMPLAZAR 		persona.setDirections(new ArrayList<Direccion>());
//REEMPLAZAR 		persona.setTelefonos(new ArrayList<Telefono>());
		TipoDocumento tipoDoc = new TipoDocumento();
		tipoDoc.setId(1);
		persona.setTipoDoc(tipoDoc);
		
		System.out.println("IDDDDDDDD??" + ((PersonaForm) form).getId() );
		persona.setId(((PersonaForm) form).getId());
		return persona;

	}

	public static PersonaForm getForm(Persona persona) {
		PersonaForm form=new PersonaForm();
		form.setApellido(persona.getApellido());
		form.setNacimiento(DateFormater.convertDateToString(persona.getDtNacimiento()));
		form.setEmail(persona.getEmail());
		form.setNombre(persona.getNombre());
		form.setNroDoc(persona.getNroDoc());
		form.setSexo(persona.getSexo());
		form.setId(persona.getId());
		form.setTipoDocumento(persona.getTipoDoc().getId());
		
		return form;
	}


}
