package com.country.mappers;

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
	

	public static Form getForm(Telefono telefono) {
		TelefonoForm form=new TelefonoForm();
		
	
		return form;
	}
	
}
