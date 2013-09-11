package com.country.session;

import java.io.Serializable;

public class UsuarioInfo implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	private int usuarioId=2;
	private int personaId=2;
	private int integranteId=2;
	private int empleadoId=2;
	private String tipoUsuario;
	private String nombreUsuario;
	
	
	
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
