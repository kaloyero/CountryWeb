package com.country.mappers;

import java.util.ArrayList;
import java.util.List;

import com.country.common.DateUtil;
import com.country.form.DireccionForm;
import com.country.form.Form;
import com.country.form.PersonaForm;
import com.country.form.TelefonoForm;
import com.country.hibernate.model.Direccion;
import com.country.hibernate.model.Persona;
import com.country.hibernate.model.Telefono;
import com.country.hibernate.model.TipoDocumento;

public class PersonaMapper {

	public static Persona getPersona(Form form) {
		
		Persona persona = new Persona();
		persona.setApellido(((PersonaForm) form).getApellido());
		persona.setDtNacimiento(DateUtil.convertStringToDate(((PersonaForm) form).getNacimiento()));
		persona.setEmail(((PersonaForm) form).getEmail());
		persona.setNombre(((PersonaForm) form).getNombre());
		persona.setNroDoc(((PersonaForm) form).getNroDoc());
		persona.setSexo(((PersonaForm) form).getSexo());
//TODO
//		persona.setDirections(getDirecciones(((PersonaForm) form).getListaDirecciones()));
//		persona.setTelefonos(getTelefonos(((PersonaForm) form).getListaTelefonos()));
		TipoDocumento tipoDoc = new TipoDocumento();
		tipoDoc.setId(((PersonaForm) form).getTipoDocumento());
		persona.setTipoDoc(tipoDoc);
		
		persona.setId(((PersonaForm) form).getId());
		return persona;

	}

	public static PersonaForm getForm(Persona persona,List<Direccion> dires,List<Telefono> tels) {
		PersonaForm form=new PersonaForm();
		form.setApellido(persona.getApellido());
		form.setNacimiento(DateUtil.convertDateToString(persona.getDtNacimiento()));
		form.setEmail(persona.getEmail());
		form.setNombre(persona.getNombre());
		form.setNroDoc(persona.getNroDoc());
		form.setSexo(persona.getSexo());
		form.setId(persona.getId());
		form.setTipoDocumento(persona.getTipoDoc().getId());
		form.setListaTelefonos(getTelefonosForm(tels));
		form.setListaDirecciones(getDireccionesForm(dires));
		form.setTipo(persona.getTipo());
		
		return form;
	}

	private static List<TelefonoForm> getTelefonosForm(List<Telefono> telefonos) {
		
		List<TelefonoForm> lista = new ArrayList<TelefonoForm>();
		if (telefonos != null){
			for (Telefono telefono : telefonos) {
				lista.add(TelefonoMapper.getForm(telefono));
			}
		}
		return lista;
		
	}

	private static List<DireccionForm> getDireccionesForm(List<Direccion> direcciones) {
		
		List<DireccionForm> lista = new ArrayList<DireccionForm>();
		if (direcciones != null){
			for (Direccion direccion : direcciones) {
				lista.add(DireccionMapper.getForm(direccion));
			}
		}
		return lista;
		
	}

	
	private static List<Telefono> getTelefonos(List<TelefonoForm> telefonos) {
		
		List<Telefono> lista = new ArrayList<Telefono>();
		if (telefonos != null){
			for (TelefonoForm telefono : telefonos) {
				lista.add(TelefonoMapper.getTelefono(telefono));
			}
		}
		return lista;
		
	}

	private static List<Direccion> getDirecciones(List<DireccionForm> direcciones) {
		
		List<Direccion> lista = new ArrayList<Direccion>();
		if (direcciones != null){
			for (DireccionForm direccion : direcciones) {
				lista.add(DireccionMapper.getDireccion(direccion));
			}
		}
		return lista;
		
	}
	
}
