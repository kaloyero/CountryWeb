package com.country.form;

import java.util.Date;

public class InstructorForm extends Form  {

	private Integer id;
	
	private Date fechaComienzo;
	private Date fechaFin;
	private PersonaForm persona ;
	
	public InstructorForm() {
		persona= new PersonaForm();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public PersonaForm getPersona() {
		return persona;
	}
	public void setPersona(PersonaForm persona) {
		this.persona = persona;
	}


}
