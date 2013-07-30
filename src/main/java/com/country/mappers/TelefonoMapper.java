package com.country.mappers;

import org.json.simple.JSONObject;

import com.country.form.Form;
import com.country.form.TelefonoForm;
import com.country.hibernate.model.Telefono;
import com.country.hibernate.model.TipoTelefono;

public class TelefonoMapper {

	public static Telefono getTelefono(Form form) {
		
		Telefono dto = new Telefono();

		dto.setId(((TelefonoForm) form).getId());
		dto.setCodigoArea(Integer.parseInt(((TelefonoForm) form).getCodigoArea()));
		dto.setCodigoPais(Integer.parseInt(((TelefonoForm) form).getCodigoPais()));
		dto.setNumero(Integer.parseInt(((TelefonoForm) form).getNumero()));
		dto.setPersona(((TelefonoForm) form).getPersona());
		dto.setPrefijo(Integer.parseInt(((TelefonoForm) form).getPrefijo()));
		TipoTelefono tipoTel = new TipoTelefono();
		tipoTel.setId(((TelefonoForm) form).getTipoTelefono());
		dto.setTipoTelefono(tipoTel);
		
		return dto;

	}
	//Devolver un telefono en base a un Json recibido
	public static Telefono getTelefono(JSONObject nodo) {
		
		Telefono dto = new Telefono();

		//dto.setId(((TelefonoForm) form).getId());
		dto.setCodigoArea(((Long) nodo.get("Telefono")).intValue());
		dto.setCodigoPais(((Long) nodo.get("Telefono")).intValue());
		dto.setNumero(((Long) nodo.get("Telefono")).intValue());
		dto.setPrefijo(((Long) nodo.get("Telefono")).intValue());
		TipoTelefono tipoTel = new TipoTelefono();
		tipoTel.setId(1);
		dto.setTipoTelefono(tipoTel);
		
		return dto;

	}
	

	public static TelefonoForm getForm(Telefono telefono) {
		TelefonoForm form=new TelefonoForm();
		
		form.setId(telefono.getId());
		form.setCodigoArea(String.valueOf(telefono.getCodigoArea()));
		form.setCodigoPais(String.valueOf(telefono.getCodigoPais()));
		form.setNumero(String.valueOf(telefono.getNumero()));
		form.setPersona(telefono.getPersona());
		form.setPrefijo(String.valueOf(telefono.getPrefijo()));
		form.setTipoTelefono(telefono.getTipoTelefono().getId());
		form.setTipoTelefonoNombre(telefono.getTipoTelefono().getNombre());
		
	
		return form;
	}
	
}
