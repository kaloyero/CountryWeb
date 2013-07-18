package com.country.form;



public class TelefonoForm extends Form  {

	private Integer id=0;
	private String codigoPais;
	private String codigoArea;
	private String prefijo;
	private Integer tipoTelefono;
	private String tipoTelefonoNombre;
	private String numero;
	private int persona;
	
	public String getTipoTelefonoNombre() {
		return tipoTelefonoNombre;
	}
	public void setTipoTelefonoNombre(String tipoTelefonoNombre) {
		this.tipoTelefonoNombre = tipoTelefonoNombre;
	}

	public int getPersona() {
		return persona;
	}
	public void setPersona(int persona) {
		this.persona = persona;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	public String getPrefijo() {
		return prefijo;
	}
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}
	public Integer getTipoTelefono() {
		return tipoTelefono;
	}
	public void setTipoTelefono(Integer tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	
}
