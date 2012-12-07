package com.country.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "actividades", catalog = "country")
public class Actividad implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "IdActividad", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "Nombre")
	private  String nombre;
	
	@Column(name = "Descripcion")
	private  String descripcion;
	
	@Column(name = "FechaIni")
	private  Date fechaComienzo ;
	
	@Column(name = "FechaFin")
	private  Date fechaFin ;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "IDCONCEPTO")
	private  Concepto  concepto ;
//	private  List <Cronograma> cronogramas ;
//	private List <Persona> integrantes;
//	private Instructor instructor;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaComienzo() {
		return fechaComienzo;
	}

	public void setFechaComienzo(Date fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Concepto getConcepto() {
		return concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}
	
	
	

}
