package com.country.form;

public class UnidadForm extends Form  {

	private Integer id=0;
	
	private String code;
	private String descripcion;
	
	public UnidadForm() {
	}
	
	public Integer getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

}
