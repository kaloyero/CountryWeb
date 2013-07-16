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
@Table(name = "recursoReservas", catalog = "country")
public class Reserva implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Reserva() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdReserva", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "Fecha")
	private  Date fecha ;

	@Column(name = "Descripcion")
	private  String descripcion ;
	
    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="IdRecurso",updatable = false, insertable = false)	
	private  Recurso recurso ;

	@Column(name = "HoraIni")
	private  int horaIni ;

	@Column(name = "Duracion")
	private  int duracion ;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdEvento",nullable=true)		
	private  Evento evento;
	
//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="IdIntegrante",updatable = false, insertable = false)	
//	private  Integrante integrante;

	@Column(name = "IdIntegrante")
	private  int integrante ;

	
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	
	public int getIntegrante() {
		return integrante;
	}

	public void setIntegrante(int integrante) {
		this.integrante = integrante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public int getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(int horaIni) {
		this.horaIni = horaIni;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

}
