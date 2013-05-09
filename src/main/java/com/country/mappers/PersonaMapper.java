package com.country.mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.country.common.DateFormater;
import com.country.common.FormaterObject;
import com.country.form.Form;
import com.country.form.PersonaForm;
import com.country.hibernate.model.Direccion;
import com.country.hibernate.model.Persona;
import com.country.hibernate.model.Telefono;
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

	public static PersonaForm getForm(Persona persona,List<Direccion> dires,List<Telefono> tels) {
		PersonaForm form=new PersonaForm();
		form.setApellido(persona.getApellido());
		form.setNacimiento(DateFormater.convertDateToString(persona.getDtNacimiento()));
		form.setEmail(persona.getEmail());
		form.setNombre(persona.getNombre());
		form.setNroDoc(persona.getNroDoc());
		form.setSexo(persona.getSexo());
		form.setId(persona.getId());
		form.setTipoDocumento(persona.getTipoDoc().getId());
		form.setDirecciones(getDirecciones(dires));
		form.setTelefonos(getTelefonos(tels));
		
		return form;
	}

	private static Map<Integer, String> getTelefonos(List<Telefono> telefonos) {
		
		Map<Integer, String> lista = new HashMap<Integer, String>();
		for (Telefono telefono : telefonos) {
			lista.put(telefono.getId(), FormaterObject.getFormatPhone(telefono));
		}
		
		return lista;
		
	}

	private static Map<Integer, String> getDirecciones(List<Direccion> dires) {
		Map<Integer, String> lista = new HashMap<Integer, String>();
		for (Direccion direccion : dires) {
			lista.put(direccion.getId(), FormaterObject.getFormatDirection(direccion));
		}
		
		return lista;
	}

	public static List<Telefono> getTelefonosDto(PersonaForm form) {
		
		
		return null;
		
	}

	public static List<Telefono> getDireccionesDto (PersonaForm form) {
		
		return null;
	}

	
}
