package com.country.mappers;


import com.country.form.Form;
import com.country.form.TipoForm;
import com.country.form.TipoRazaForm;
import com.country.hibernate.model.Especie;
import com.country.hibernate.model.Raza;
import com.country.hibernate.model.TipoAutorizacion;
import com.country.hibernate.model.TipoDocumento;
import com.country.hibernate.model.TipoInfraccion;
import com.country.hibernate.model.TipoPagos;
import com.country.hibernate.model.TipoRecurso;
import com.country.hibernate.model.TipoVacuna;
import com.country.hibernate.model.TipoVehiculo;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class TipoMapper {

//	public static E getTipo(TipoForm typeForm)
//			throws ParseException {
//		
//		IType type = new IType();
//		type.setId(type.getId());
//		type.setNombre(type.getNombre());
//		return type;
//	
//	}
//	
//	public static TipoForm getForm(IType tipo)
//			throws ParseException {
//		
//		TipoForm form = new TipoForm();
//		form.setId(tipo.getId());
//		form.setNombre(tipo.getNombre());
//		return form;
//	
//	}

	public static Raza getTipoRaza(Form form)
			throws ParseException {
		
		Raza type = new Raza();
		type.setId(((TipoRazaForm) form).getId());
		type.setNombre(((TipoRazaForm) form).getNombre());
		Especie especie = new Especie();
		especie.setId(((TipoRazaForm) form).getEspecie());
		type.setEspecie(especie);
		
		return type;
	
	}
	
	public static TipoAutorizacion getTipoAutorizacion(TipoForm form)
		throws ParseException {
	
		TipoAutorizacion type = new TipoAutorizacion();
		type.setId(form.getId());
		type.setNombre(form.getNombre());
		return type;
	
	}

	public static TipoPagos getTipoPagos(TipoForm form)
			throws ParseException {
		
		TipoPagos type = new TipoPagos();
		type.setId(form.getId());
		type.setNombre(form.getNombre());
		return type;
	
	}

	public static TipoVehiculo getTipoVehiculo(TipoForm form)
			throws ParseException {
		
		TipoVehiculo type = new TipoVehiculo();
		type.setId(form.getId());
		type.setNombre(form.getNombre());
		return type;
	
	}	
	
	public static TipoVacuna getTipoVacuna(TipoForm form)
			throws ParseException {
		
		TipoVacuna type = new TipoVacuna();
		type.setId(form.getId());
		type.setNombre(form.getNombre());
		return type;
	
	}

	public static TipoRecurso getTipoRecursos(TipoForm form)
			throws ParseException {
		
		TipoRecurso type = new TipoRecurso();
		type.setId(form.getId());
		type.setNombre(form.getNombre());
		return type;
	
	}

	public static TipoDocumento getTipoDocumento(TipoForm form)
			throws ParseException {
		
			TipoDocumento type = new TipoDocumento();
			type.setId(form.getId());
			type.setNombre(form.getNombre());
			return type;
		
		}

	public static Especie getTipoEspecie(TipoForm form)
			throws ParseException {
		
		Especie type = new Especie();
		type.setId(form.getId());
		type.setNombre(form.getNombre());
		return type;
	
	}

	public static TipoInfraccion getTipoInfraccion(TipoForm form)
			throws ParseException {
		
		TipoInfraccion type = new TipoInfraccion();
		type.setId(form.getId());
		type.setNombre(form.getNombre());
		return type;
	
	}

	public static TipoForm getForm(TipoAutorizacion tipo)
		throws ParseException {
	
		TipoForm form = new TipoForm();
		form.setId(tipo.getId());
		form.setNombre(tipo.getNombre());
		return form;
	
	}

	public static TipoForm getForm(TipoDocumento tipo)
			throws ParseException {
		
		TipoForm form = new TipoForm();
		form.setId(tipo.getId());
		form.setNombre(tipo.getNombre());
		return form;
	
	}
	
	public static TipoForm getForm(Especie tipo)
			throws ParseException {
		
		TipoForm form = new TipoForm();
		form.setId(tipo.getId());
		form.setNombre(tipo.getNombre());
		return form;
	
	}

	public static TipoForm getForm(TipoInfraccion tipo)
			throws ParseException {
		
		TipoForm form = new TipoForm();
		form.setId(tipo.getId());
		form.setNombre(tipo.getNombre());
		return form;
	
	}

	public static TipoRazaForm getForm(Raza tipo)
			throws ParseException {
		
		TipoRazaForm form = new TipoRazaForm();
		form.setId(tipo.getId());
		form.setNombre(tipo.getNombre());
		form.setEspecie(tipo.getEspecie().getId());
		return form;
	
	}

	public static TipoForm getForm(TipoRecurso tipo)
			throws ParseException {
		
		TipoForm form = new TipoForm();
		form.setId(tipo.getId());
		form.setNombre(tipo.getNombre());
		return form;
	
	}
	
	public static TipoForm getForm(TipoVacuna tipo)
			throws ParseException {
		
		TipoForm form = new TipoForm();
		form.setId(tipo.getId());
		form.setNombre(tipo.getNombre());
		return form;
	
	}
	
	public static TipoForm getForm(TipoVehiculo tipo)
			throws ParseException {
		
		TipoForm form = new TipoForm();
		form.setId(tipo.getId());
		form.setNombre(tipo.getNombre());
		return form;
	
	}	
	
	public static TipoForm getForm(TipoPagos tipo)
			throws ParseException {
		
		TipoForm form = new TipoForm();
		form.setId(tipo.getId());
		form.setNombre(tipo.getNombre());
		return form;
	
	}

}
