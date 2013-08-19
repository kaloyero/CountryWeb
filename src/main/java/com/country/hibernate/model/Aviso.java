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
@Table(name = "Avisos")
public class Aviso implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdAviso", unique = true, nullable = false)	
	private Integer id;
	
	@Column(name = "Fecha")
	private Date fecha;
	
  	@Column(name = "Titulo")
	private String tittle;
	
  	@Column(name = "Encabezado")
	private String header;
	
	@Column(name = "Cuerpo")
	private String body;
	
	@Column(name = "Cierre")
	private String close;
	
	@Column(name = "FechaFin")
	private Date fechaFin;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdAvisoCategoria",updatable = false, insertable = true)	
	private  AvisoCategoria categoria;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdPersona",updatable = false, insertable = true)	
	private  Persona persona;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public AvisoCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(AvisoCategoria categoria) {
		this.categoria = categoria;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	
	
}
