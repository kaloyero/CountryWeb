package com.country.mappers;

import java.util.ArrayList;
import java.util.List;

import com.country.common.DateUtil;
import com.country.common.MapperUtil;
import com.country.form.MensajeDetalleForm;
import com.country.form.MensajeForm;
import com.country.hibernate.model.Empleado;
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
		Empleado emp = new Empleado();
		emp.setId(form.getIdEmpleado());
		mensaje.setEmpleado(emp);
		
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
		//TODO ,el integrante puede ser nulo??
		if (mensaje.getIntegrante() != null){
     		form.setIntegranteNombre(mensaje.getIntegrante().getPersona().getNombre());
     		form.setIntegranteApellido(mensaje.getIntegrante().getPersona().getApellido());
     		form.setIntegranteUnidad(mensaje.getIntegrante().getUnidad().getCode());
		}
		form.setEnvio(MapperUtil.getStatusUserForm(mensaje.getEnvio()));
		//OJO ,el integrante puede ser nulo//NO! aca debe poner el nombre del usuario conectado
		form.setIdIntegrante(mensaje.getIntegrante().getId());
 		form.setIntegranteNombre(mensaje.getIntegrante().getUnidad().getCode() + " | " +
							mensaje.getIntegrante().getPersona().getNombre() + " " +
							mensaje.getIntegrante().getPersona().getApellido() + " " +
							mensaje.getIntegrante().getPersona().getTipoDoc().getNombre() + " " + 
							mensaje.getIntegrante().getPersona().getNroDoc() );
		form.setResolucion(mensaje.getResolucion());
		form.setIdEmpleado(mensaje.getEmpleado().getId());
		form.setEmpleadoNombre(mensaje.getEmpleado().getPersona().getNombre() + " " + mensaje.getEmpleado().getPersona().getApellido());
		form.setTipo(mensaje.getTipo());
		//form.setDetalles(getDetalles(mensaje.getDetalles()));
		
		return form;
	
	}

	public static List<MensajeDetalleForm> getDetalles(List<MensajeDetalles> detalles) {
		List<MensajeDetalleForm> lista = new ArrayList<MensajeDetalleForm>();
		for (MensajeDetalles msjDet : detalles) {
			MensajeDetalleForm msj = new MensajeDetalleForm();
			msj.setId(msjDet.getId());
			msj.setMensaje(msjDet.getMensajeDetalle());
			msj.setNombreUsuario(msjDet.getPersona().getNombre() + " " + msjDet.getPersona().getApellido());

		}
		
		return lista;
	}

	
}
