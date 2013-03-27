package com.country.form;

public class VehiculoForm extends Form  {

	private Integer id =0;
	private String codigo;
	private String descripcion;
	private String cilindrada;
	private Integer unidad;
	private Integer tipoVeh;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(String cilindrada) {
		this.cilindrada = cilindrada;
	}
	public Integer getUnidad() {
		return unidad;
	}
	public void setUnidad(Integer unidad) {
		this.unidad = unidad;
	}
	public Integer getTipoVeh() {
		return tipoVeh;
	}
	public void setTipoVeh(Integer tipoVeh) {
		this.tipoVeh = tipoVeh;
	}
	
}
