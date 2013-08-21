package com.country.form;


public class InstructorForm extends Form  {

	private Integer id =0;
	
	private String fechaComienzo;
	private String fechaFin;
	private PersonaForm persona ;
	private boolean estado;
	
	public InstructorForm() {
		persona= new PersonaForm();
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFechaComienzo() {
		return fechaComienzo;
	}
	public void setFechaComienzo(String fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public PersonaForm getPersona() {
		return persona;
	}
	public void setPersona(PersonaForm persona) {
		this.persona = persona;
	}


}
