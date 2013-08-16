package com.country.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AccesosGrupos")
public class AccesoGrupo implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public AccesoGrupo() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdAccesoGrupo", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "NombreGrupo")
	private  String grupo ;

	@Column(name = "Tag")
	private  String tag;

	@Column(name = "Descripcion")
	private String descripcion;
	
	@Column(name = "Estado")
	private String estado;

	
}
