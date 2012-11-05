package com.country.hibernate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Actividad implements Serializable {

	private int id;
	private  String nombre;
	private  String descripcion;
	private  Date fechaComienzo ;
	private  Date fechaFin ;
	private  Concepto  concepto ;
	private  List <Cronograma> cronogramas ;
	private List <Persona> integrantes;
	private Instructor instructor;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public Concepto getConcepto() {
		return concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}

	public List<Persona> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<Persona> integrantes) {
		this.integrantes = integrantes;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
	
	public List<Cronograma> getCronogramas() {
		return cronogramas;
	}
	
	public void setCronogramas(List<Cronograma> cronogramas) {
		this.cronogramas = cronogramas;
	}
	
}
