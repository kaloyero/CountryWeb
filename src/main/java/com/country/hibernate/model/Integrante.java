package com.country.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Integrantes", catalog = "country")
public class Integrante extends Persona {
	
	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "IdIntegrante", unique = true, nullable = false)	
	private Integer id;
	
	@Column(name = "Tipo")
	private String tipo;
	
	@Column(name = "IdPersona")
	private Persona persona;
	
	//@Column(name = "IdUnidad")
	//private Unidad unidad;
	
	
	
	
}
