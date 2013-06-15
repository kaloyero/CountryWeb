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
@Table(name = "AvisoSuscripcion", catalog = "country")
public class AvisoSuscripcion implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IDAvisoSuscripcion", unique = true, nullable = false)	
	private Integer id;

	@Column(name = "IdAvisoCategoria")
	private int categoria;
	
	@Column(name = "IdIntegrante")
	private int integrante;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getIntegrante() {
		return integrante;
	}

	public void setIntegrante(int integrante) {
		this.integrante = integrante;
	}

}
