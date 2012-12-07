package com.country.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Integrantes", catalog = "country")
public class Integrante implements Serializable {
	
	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdIntegrante", unique = true, nullable = false)	
	private Integer id;
	
	@Column(name = "Tipo")
	private String tipo;
	
	@Column(name = "IdPersona")
	private Persona persona;
	
	//@Column(name = "IdUnidad")
	//private Unidad unidad;
	
}
