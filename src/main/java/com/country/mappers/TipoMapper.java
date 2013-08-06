package com.country.mappers;


import com.country.common.Constants;
import com.country.common.DateUtil;
import com.country.form.AvisoCategoriaForm;
import com.country.form.Form;
import com.country.form.TipoForm;
import com.country.form.TipoInfraccionForm;
import com.country.form.TipoRazaForm;
import com.country.form.TipoVacunaForm;
import com.country.hibernate.model.AvisoCategoria;
import com.country.hibernate.model.Especie;
import com.country.hibernate.model.MensajeCategorias;
import com.country.hibernate.model.NoticiaCategorias;
import com.country.hibernate.model.Raza;
import com.country.hibernate.model.Tarifa;
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

	public static MensajeCategorias getMensajeCategoria(TipoForm form)
			throws ParseException {
		
			MensajeCategorias type = new MensajeCategorias();
			type.setId(form.getId());
			type.setNombre(form.getNombre());
			
			return type;
		
	}

	public static NoticiaCategorias getNoticiaCategoria(TipoForm form)
			throws ParseException {
		
			NoticiaCategorias type = new NoticiaCategorias();
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
	
	public static TipoVacuna getTipoVacuna(TipoVacunaForm form)
			throws ParseException {
		
		TipoVacuna type = new TipoVacuna();
		type.setId(form.getId());
		type.setNombre(form.getNombre());
		type.setVigencia(form.getVigencia());
		if (form.isObligatoria()){
			type.setObligatorio(Constants.TRUE);
		} else {
			type.setObligatorio(Constants.FALSE);
		}
		Especie especie = new Especie();
		especie.setId(form.getEspecie());
		type.setEspecie(especie);
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

	public static TipoInfraccion getTipoInfraccion(TipoInfraccionForm form)
			throws ParseException {
		
		TipoInfraccion type = new TipoInfraccion();
		type.setId(form.getId());
		type.setNombre(form.getNombre());
		//seteo la fecha del concepto
		form.getConcepto().setFechaComienzo(form.getFechaIni());
		form.getConcepto().setNombre(form.getNombre());
		type.setConcepto(ConceptoMapper.getConcepto(form.getConcepto()));
		type.setFechaIni(DateUtil.convertStringToDate(form.getFechaIni()));
		type.setFechaFin(DateUtil.convertStringToDate(form.getFechaFin()));
		return type;
	
	}

	public static AvisoCategoria getAvisoCategoria(AvisoCategoriaForm form)
			throws ParseException {
		
		AvisoCategoria type = new AvisoCategoria();
		type.setId(form.getId());
		type.setNombre(form.getNombre());
		//seteo la fecha del concepto
		form.getConcepto().setFechaComienzo(form.getFechaIni());
		form.getConcepto().setNombre(form.getNombre());
		type.setConcepto(ConceptoMapper.getConcepto(form.getConcepto()));
		type.setDateIni(DateUtil.convertStringToDate(form.getFechaIni()));
		type.setDateEnd(DateUtil.convertStringToDate(form.getFechaFin()));
		type.setPublishDays(String.valueOf(form.getDiasPublicacion()));
		return type;
	
	}

	
	public static TipoForm getForm(TipoAutorizacion tipo)
		throws ParseException {
	
		TipoForm form = new TipoForm();
		form.setId(tipo.getId());
		form.setNombre(tipo.getNombre());
		return form;
	
	}

	public static TipoForm getForm(MensajeCategorias tipo)
			throws ParseException {
		
			TipoForm form = new TipoForm();
			form.setId(tipo.getId());
			form.setNombre(tipo.getNombre());
			return form;
		
		}

	public static TipoForm getForm(NoticiaCategorias tipo)
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

	public static TipoInfraccionForm getForm(TipoInfraccion tipo,Tarifa tarifa)
			throws ParseException {
		
		TipoInfraccionForm form = new TipoInfraccionForm();
		form.setId(tipo.getId());
		form.setNombre(tipo.getNombre());
		form.setConcepto(ConceptoMapper.getForm(tipo.getConcepto(), tarifa));
		form.setFechaIni(DateUtil.convertDateToString(tipo.getFechaIni()));
		form.setFechaFin(DateUtil.convertDateToString(tipo.getFechaFin()));
		
		return form;
	
	}

	public static AvisoCategoriaForm getForm(AvisoCategoria tipo,Tarifa tarifa)
			throws ParseException {
		
		AvisoCategoriaForm form = new AvisoCategoriaForm();
		form.setId(tipo.getId());
		form.setNombre(tipo.getNombre());
		form.setConcepto(ConceptoMapper.getForm(tipo.getConcepto(), tarifa));
		form.setFechaIni(DateUtil.convertDateToString(tipo.getDateIni()));
		form.setFechaFin(DateUtil.convertDateToString(tipo.getDateEnd()));
		form.setDiasPublicacion(Integer.parseInt(tipo.getPublishDays()));
		
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
	
	public static TipoVacunaForm getForm(TipoVacuna tipo)
			throws ParseException {
		
		TipoVacunaForm form = new TipoVacunaForm();
		form.setId(tipo.getId());
		if (Constants.TRUE.equals(tipo.getObligatorio())){
			form.setObligatoria(true);	
		} else {
			form.setObligatoria(false);
		}
		form.setVigencia(tipo.getVigencia());
		form.setNombre(tipo.getNombre());
		form.setEspecie(tipo.getEspecie().getId());
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
