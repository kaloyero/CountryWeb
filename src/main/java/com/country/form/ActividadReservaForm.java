package com.country.form;

import java.util.ArrayList;
import java.util.List;

public class ActividadReservaForm extends Form {

	private int id;
	private String nombre;
	private List <CronogramaForm> cronograma= new ArrayList();
	private String descripcion = null;

	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



}
