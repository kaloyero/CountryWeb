package com.country.form;


public class IntegranteActividadForm extends Form  {

	private Integer id =0;
	private int integrante;
	private int actividad;
	private String fechaIni;
	private String fechaFin;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public int getIntegrante() {
		return integrante;
	}
	public void setIntegrante(int integrante) {
		this.integrante = integrante;
	}
	public int getActividad() {
		return actividad;
	}
	public void setActividad(int actividad) {
		this.actividad = actividad;
	}
	public String getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
}
