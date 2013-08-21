package com.country.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UsuarioAccesos")
public class UsuarioAccesos implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public UsuarioAccesos() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "IdUsuario")
	private  int usuario ;

	@Column(name = "IdAcceso")
	private  int acceso ;

}
