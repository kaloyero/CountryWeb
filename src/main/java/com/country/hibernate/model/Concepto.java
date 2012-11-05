package com.country.hibernate.model;

import java.io.Serializable;
import java.util.Date;

public class Concepto implements Serializable {

	private  int id ;
	private  String descripcion ;
	private  Date fechaComienzo ;
	private  Date fechaFin ;
	
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
	
	public Date getFechaComienzo() {
		return fechaComienzo;
	}
	
	public void setFechaComienzo(Date fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
}
