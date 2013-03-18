package com.country.mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.country.form.ConceptoForm;
import com.country.form.Form;
import com.country.hibernate.model.Concepto;
import com.country.hibernate.model.Tarifa;

public class ConceptoMapper {

	public static Concepto getConcepto(Form form) {
		
		Concepto concepto = new Concepto();
		concepto.setId(((ConceptoForm) form).getId());
		concepto.setDescripcion(((ConceptoForm) form).getDescripcion());
		concepto.setNombre(((ConceptoForm) form).getNombre());
		concepto.setFechaComienzo(new Date(2012, 12, 12));
  //      concepto.setTarifas(getTarifa(form,concepto));
		return concepto;

	}

	public static ConceptoForm getForm(Concepto concepto,Tarifa tarifa) {
		ConceptoForm form=new ConceptoForm();
		form.setId(concepto.getId());
		form.setNombre(concepto.getNombre());
		form.setDescripcion(concepto.getDescripcion());
		form.setImporte(tarifa.getImporte());
	
		return form;
	}
	
	public static List<Tarifa> getTarifa (Form form,Concepto concepto){
		List<Tarifa> tarifas = new ArrayList<Tarifa>();

		Tarifa tarifa = new Tarifa();
		tarifa.setImporte(((ConceptoForm) form).getImporte());
		tarifa.setFechaComienzo(new Date(2012, 12, 12));
		tarifa.setConcepto(concepto.getId());
		tarifas.add(tarifa);
		return tarifas;
		
	}



}
