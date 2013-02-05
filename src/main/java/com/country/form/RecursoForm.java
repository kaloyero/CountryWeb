package com.country.form;


public class RecursoForm extends Form  {

	private  int id =0;
	
	private  String descripcion ;
	private String nombre;
	private double importe;
	private int maxTiempoReserva;
	
	private int tipoRecurso ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public int getMaxTiempoReserva() {
		return maxTiempoReserva;
	}
	public void setMaxTiempoReserva(int maxTiempoReserva) {
		this.maxTiempoReserva = maxTiempoReserva;
	}
	public int getTipoRecurso() {
		return tipoRecurso;
	}
	public void setTipoRecurso(int tipoRecurso) {
		this.tipoRecurso = tipoRecurso;
	}


	

}
