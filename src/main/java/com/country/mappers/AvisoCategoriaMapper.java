package com.country.mappers;

import com.country.form.AvisoCategoriaForm;
import com.country.form.Form;
import com.country.hibernate.model.AvisoCategoria;

public class AvisoCategoriaMapper {

	public static AvisoCategoria getAvisoCategoria(Form form) {
		
		AvisoCategoria dto = new AvisoCategoria();

		return dto;

	}

	public static Form getForm(AvisoCategoria dto) {
		AvisoCategoriaForm form=new AvisoCategoriaForm();

		
		return form;
	}
	
}
