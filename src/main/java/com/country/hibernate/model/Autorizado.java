package com.country.hibernate.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "autorizados", catalog = "country")
public class Autorizado implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdAutorizado", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "FechaIni")
	private  Date fechaIni ;
	
	@Column(name = "FechaFin")
	private  Date fechaFin ;

	@Column(name = "Descripcion")
	private  String descripcion;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdPersona")		
	private  Persona persona;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdUnidad")		
	private  Unidad unidad;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdTipoAutorizado")		
	private  TipoAutorizacion tipoAutorizacion;
	
}
