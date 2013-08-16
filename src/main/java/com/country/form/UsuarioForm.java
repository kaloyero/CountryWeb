package com.country.form;


public class UsuarioForm extends Form  {

	private int id =0;
	private String usuario;
	private String descripcion;
	private String clave;
	private String fechaCreacion;
	private String fechaCaduca;
	private boolean estado;

	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getFechaCaduca() {
		return fechaCaduca;
	}
	public void setFechaCaduca(String fechaCaduca) {
		this.fechaCaduca = fechaCaduca;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
}
