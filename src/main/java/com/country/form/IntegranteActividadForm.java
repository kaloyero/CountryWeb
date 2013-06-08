package com.country.form;


public class IntegranteActividadForm extends Form  {

	private Integer id =0;
	private IntegranteForm integrante;
	private ActividadForm actividad;
	private String fechaIni;
	private String fechaFin;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public IntegranteForm getIntegrante() {
		return integrante;
	}
	public void setIntegrante(IntegranteForm integrante) {
		this.integrante = integrante;
	}
	public ActividadForm getActividad() {
		return actividad;
	}
	public void setActividad(ActividadForm actividad) {
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
