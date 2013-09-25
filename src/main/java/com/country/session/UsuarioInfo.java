package com.country.session;

import java.io.Serializable;

import com.country.hibernate.model.Unidad;

public class UsuarioInfo implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	private int usuarioId;
	private int personaId;
	private int integranteId;
	private Unidad unidad;
	private int empleadoId;
	private String tipoUsuario;
	private String nombreUsuario;
	private String errorDescripcion;
	
	
	public Unidad getUnidad() {
		return unidad;
	}
	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
	public String getErrorDescripcion() {
		return errorDescripcion;
	}
	public void setErrorDescripcion(String errorDescripcion) {
		this.errorDescripcion = errorDescripcion;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	public int getPersonaId() {
		return personaId;
	}
	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}
	public int getIntegranteId() {
		return integranteId;
	}
	public void setIntegranteId(int integranteId) {
		this.integranteId = integranteId;
	}
	public int getEmpleadoId() {
		return empleadoId;
	}
	public void setEmpleadoId(int empleadoId) {
		this.empleadoId = empleadoId;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
		

}
