package com.country.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Telefonos")
public class Telefono implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdTelefono", unique = true, nullable = false)	
	private int id;
	
	@Column(name = "CodigoPais")
	private int codigoPais;
	
	@Column(name = "CodigoArea")
	private int codigoArea;
	
	@Column(name = "Prefijo")
	private int prefijo;
	
    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="IdTipoTelefono",updatable = true, insertable = true)	
	private TipoTelefono tipoTelefono;
	
	@Column(name = "Numero")
	private int numero;
	
    @Column(name = "IdPersona")
	private int persona;
	
	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

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

	public int getPersona() {
		return persona;
	}

	public void setPersona(int persona) {
		this.persona = persona;
	}
  
}
