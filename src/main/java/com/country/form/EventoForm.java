package com.country.form;


public class EventoForm extends Form  {

	private int id =0;
	private  String descripcion ;
	private  String fecha ;
	private String nombre;
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	private Integer hourIni;



	private int cupo;

	
	public int getId() {
		return id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public int getCupo() {
		return cupo;
	}


	public void setCupo(int cupo) {
		this.cupo = cupo;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Integer getHourIni() {
		return hourIni;
	}


	public void setHourIni(Integer hourIni) {
		this.hourIni = hourIni;
	}
	
	

}
