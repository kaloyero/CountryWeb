package com.country.form;

import java.util.ArrayList;
import java.util.List;

public class ActividadReservaForm extends Form {

	private String nombre;
	private List <CronogramaForm> cronograma= new ArrayList();
	
	public ActividadReservaForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<CronogramaForm> getCronograma() {
		return cronograma;
	}
	public void setCronograma(List<CronogramaForm> cronograma) {
		this.cronograma = cronograma;
	}



}
