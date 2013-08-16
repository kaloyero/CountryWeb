package com.country.mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.country.common.DateUtil;
import com.country.common.MapperUtil;
import com.country.form.MensajeForm;
import com.country.hibernate.model.Integrante;
import com.country.hibernate.model.Mensaje;
import com.country.hibernate.model.MensajeCategorias;
import com.country.hibernate.model.MensajeDetalles;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class MensajeMapper {

	public static Mensaje getMensaje(MensajeForm form)
			throws ParseException {
		
		Mensaje	mensaje = new Mensaje();
		mensaje.setId(form.getId());
		mensaje.setAsunto(form.getAsunto());
		MensajeCategorias cat = new MensajeCategorias();
		cat.setId(form.getCategoria());
		mensaje.setCategoria(cat);
		mensaje.setEstado(form.getEstado());
		mensaje.setFecha(DateUtil.convertStringToDate((form.getFecha())));
		mensaje.setFechaCierre(DateUtil.convertStringToDate((form.getFechaCierre())));
		Integrante integ = new Integrante();
		integ.setId(form.getIdIntegrante());
		mensaje.setEnvio(MapperUtil.getStatusUserEntity(form.isEnvio()));
		mensaje.setIntegrante(integ);
		mensaje.setTipo(form.getTipo());
		mensaje.setResolucion(form.getResolucion());
		mensaje.setTipo(form.getTipo());
		
		return mensaje;
	
	}
	
	public static MensajeForm getForm(Mensaje mensaje)
			throws ParseException {
		
		MensajeForm form=new MensajeForm();
		form.setId(mensaje.getId());
		form.setAsunto(mensaje.getAsunto());
		form.setCategoria(mensaje.getCategoria().getId());
		form.setCategoriaDescripcion(mensaje.getCategoria().getNombre());
		form.setEstado(mensaje.getEstado());
		form.setFecha(DateUtil.convertDateToString(mensaje.getFecha()));
		form.setFechaCierre(DateUtil.convertDateToString(mensaje.getFechaCierre()));
		form.setEnvio(MapperUtil.getStatusUserForm(mensaje.getEnvio()));
		//OJO ,el integrante puede ser nulo//NO! aca debe poner el nombre del usuario conectado
		form.setIdIntegrante(mensaje.getIntegrante().getId());
 		form.setIntegranteNombre(mensaje.getIntegrante().getUnidad().getCode() + " | " +
							mensaje.getIntegrante().getPersona().getNombre() + " " +
							mensaje.getIntegrante().getPersona().getApellido() + " " +
							mensaje.getIntegrante().getPersona().getTipoDoc().getNombre() + " " + 
							mensaje.getIntegrante().getPersona().getNroDoc() );
		form.setResolucion(mensaje.getResolucion());

		form.setTipo(mensaje.getTipo());
		form.setDetalles(getDetalles(mensaje.getDetalles()));
		
		return form;
	
	}

	public static Map<Integer, String> getDetalles(List<MensajeDetalles> detalles) {
		Map<Integer, String> lista = new HashMap<Integer, String>();
		for (MensajeDetalles msjDet : detalles) {
			lista.put(msjDet.getId(), msjDet.getMensajeDetalle());
		}
		
		return lista;
	}

	
}
