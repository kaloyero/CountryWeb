package com.country.mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.country.form.ActividadForm;
import com.country.form.ConceptoForm;
import com.country.form.Form;
import com.country.form.RecursoForm;
import com.country.hibernate.model.Concepto;
import com.country.hibernate.model.Recurso;
import com.country.hibernate.model.Tarifa;
import com.country.hibernate.model.TipoRecurso;

public class RecursoMapper {

	public static Recurso getRecurso(Form form) {
		
		Recurso recurso = new Recurso();
		recurso.setId(((RecursoForm) form).getId());
		recurso.setDescripcion(((RecursoForm) form).getDescripcion());
		recurso.setNombre(((RecursoForm) form).getNombre());
		recurso.setMaxTiempoReserv(((RecursoForm) form).getMaxTiempoReserva());
		TipoRecurso tipoRecurso =new TipoRecurso();
		tipoRecurso.setId(1);
		recurso.setTipoRecurso(tipoRecurso);
		
		recurso.setConcepto(getConcepto((RecursoForm)form));

		return recurso;

	}

	public static RecursoForm getForm(Recurso recurso) {
		RecursoForm form=new RecursoForm();
		form.setNombre(recurso.getNombre());
		form.setDescripcion(recurso.getDescripcion());
		
		//TODO se deberia tomar solo el importe reciente
		   for (Tarifa tarifa :recurso.getConcepto().getTarifas()) {
			   form.setImporte(tarifa.getImporte());
			}
	
		return form;
	}

	public static Concepto getConcepto (RecursoForm form){
		Concepto concepto = new Concepto();
		concepto.setNombre(form.getNombre());
		concepto.setFechaComienzo(new Date(2012, 12, 12));
		concepto.setTarifas(getTarifa(form,concepto));
		return concepto;
		
	}
	
	public static List<Tarifa> getTarifa (RecursoForm form,Concepto concepto){
		List<Tarifa> tarifas = new ArrayList<Tarifa>();

		Tarifa tarifa = new Tarifa();
		tarifa.setImporte(form.getImporte());
		tarifa.setFechaComienzo(new Date(2012, 12, 12));
		tarifa.setConcepto(concepto);
		tarifas.add(tarifa);
		return tarifas;
		
	}



}
