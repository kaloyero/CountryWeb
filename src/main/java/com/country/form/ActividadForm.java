package com.country.form;

import java.util.Date;

public class ActividadForm {
	private String name = null;
	private String nameCosto = null;
    private String descripcion=null;
    private Date fechaInicio=null;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameCosto() {
		return nameCosto;
	}

	public void setNameCosto(String nameConcepto) {
		this.nameCosto = nameConcepto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	
	
}
