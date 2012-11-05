package com.country.hibernate.model;

import java.io.Serializable;

public class Telefono implements Serializable {
	private int id;
	private int codigoPais;
	private int codigoArea;
	private int prefijo;
	private TipoTelefono tipoTelefono;
	private int numero;

  	public int getId() {
  		return id;
  	}
  	
	public void setId(int id) {
		this.id = id;
	}

	public int getCodigoPais() {
		return codigoPais;
	}
	
	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}
	
	public int getCodigoArea() {
		return codigoArea;
	}
	
	public void setCodigoArea(int codigoArea) {
		this.codigoArea = codigoArea;
	}
	
	public int getPrefijo() {
		return prefijo;
	}
	
	public void setPrefijo(int prefijo) {
		this.prefijo = prefijo;
	}
	
	public TipoTelefono getTipoTelefono() {
		return tipoTelefono;
	}
	
	public void setTipoTelefono(TipoTelefono tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
  
  
  
}
