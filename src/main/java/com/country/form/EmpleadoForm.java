package com.country.form;



public class EmpleadoForm extends Form  {
	private Integer id =0;
	private String puesto ;
	private String legajo ;
	private String fecha;
	private int idCategoria;	
	private PersonaForm persona ;
	private UsuarioForm usuario ;
	private boolean estado;
	
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public PersonaForm getPersona() {
		return persona;
	}
	public void setPersona(PersonaForm persona) {
		this.persona = persona;
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
	

}
