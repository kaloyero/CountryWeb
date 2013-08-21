package com.country.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Accesos")
public class Acceso implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Acceso() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IDAcceso", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "NombreAcceso")
	private  String acceso ;

	@Column(name = "IdAccesoGrupo")
	private  int grupo;
	
	@Column(name = "Tag")
	private  String tag;

	@Column(name = "Descripcion")
	private String descripcion;
	
	@Column(name = "Estado")
	private String estado;

}
