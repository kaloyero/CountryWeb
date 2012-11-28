package com.country.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Instructores", catalog = "country")
public class Instructor extends Persona {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "IdInstructor", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "FechaIni")
	private  Date fechaComienzo ;
	
	@Column(name = "FechaFin")
	private  Date fechaFin ;
	
	@Column(name = "IdPersona")
	Persona persona;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
}
