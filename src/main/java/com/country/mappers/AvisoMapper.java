package com.country.mappers;

import com.country.form.AvisoForm;
import com.country.form.Form;
import com.country.hibernate.model.Aviso;

public class AvisoMapper {

	public static Aviso getAviso(Form form) {
		
		Aviso dto = new Aviso();

		return dto;

	}

	public static Form getForm(Aviso dto) {
		AvisoForm form=new AvisoForm();

		
		return form;
	}
	
}
