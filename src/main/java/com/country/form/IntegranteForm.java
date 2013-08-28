package com.country.form;


public class IntegranteForm extends Form  {
	private Integer id =0;
	private Integer unidad;
	private String unidadCode;
	private PersonaForm persona ;
	private UsuarioForm usuario ;
	private boolean estado;
	
	
	public String getUnidadCode() {
		return unidadCode;
	}
	public void setUnidadCode(String unidadCode) {
		this.unidadCode = unidadCode;
	}
	public UsuarioForm getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioForm usuario) {
		this.usuario = usuario;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUnidad() {
		return unidad;
	}
	public void setUnidad(Integer unidad) {
		this.unidad = unidad;
	}
	public PersonaForm getPersona() {
		return persona;
	}
	public void setPersona(PersonaForm persona) {
		this.persona = persona;
	}

	
}
