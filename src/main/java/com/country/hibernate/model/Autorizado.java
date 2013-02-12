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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public TipoAutorizacion getTipoAutorizacion() {
		return tipoAutorizacion;
	}

	public void setTipoAutorizacion(TipoAutorizacion tipoAutorizacion) {
		this.tipoAutorizacion = tipoAutorizacion;
	}

	
}
