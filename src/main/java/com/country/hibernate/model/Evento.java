package com.country.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "Eventos")
public class Evento implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdEvento", unique = true, nullable = false)	
	private Integer id;
	
	@Column(name = "Fecha")
	private Date fecha;
	
	@Column(name = "HoraIni")
	private Integer hourIni;

	@Column(name = "Duracion")
	private Integer duracion;

	@Column(name = "Descripcion")
	private String description;

	@Column(name = "Cupo")
	private Integer cupo;
	
	@OneToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="IdConcepto",updatable = true, insertable = true)	
	private  Concepto  concepto ;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdIntegrante",updatable = true, insertable = true)	
	private  Integrante integrante;

//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="IdEvento",updatable = false, insertable = false)	
//	private  Reserva reserva;
//
//	
//	public Reserva getReserva() {
//		return reserva;
//	}
//
//	public void setReserva(Reserva reserva) {
//		this.reserva = reserva;
//	}

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

	public Integer getHourIni() {
		return hourIni;
	}

	public void setHourIni(Integer hourIni) {
		this.hourIni = hourIni;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public Concepto getConcepto() {
		return concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}

	public Integrante getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

}
