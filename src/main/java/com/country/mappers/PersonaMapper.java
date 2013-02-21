package com.country.mappers;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.country.form.Form;
import com.country.form.PersonaForm;
import com.country.hibernate.model.Persona;
import com.country.hibernate.model.TipoDocumento;

public class PersonaMapper {

	public static Persona getPersona(Form form) {
		
		Persona persona = new Persona();
		persona.setApellido(((PersonaForm) form).getApellido());
		persona.setDtNacimiento(new Date(2012, 12, 12));
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
		
		System.out.println("IDDDDDDDD??" + ((PersonaForm) form).getTipoDocumento() );
		persona.setId(31);
		return persona;

	}

	public static PersonaForm getForm(Persona persona) {
		PersonaForm form=new PersonaForm();
		form.setApellido(persona.getApellido());
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		form.setNacimiento(formatter.format(persona.getDtNacimiento()));
		form.setEmail(persona.getEmail());
		form.setNombre(persona.getNombre());
		form.setNroDoc(persona.getNroDoc());
		form.setSexo(persona.getSexo());
		form.setId(persona.getId());
		form.setTipoDocumento(persona.getTipoDoc().getId());
		
		return form;
	}


}
