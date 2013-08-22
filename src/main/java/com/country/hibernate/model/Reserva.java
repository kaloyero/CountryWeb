package com.country.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RecursoReservas")
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

	@Column(name = "IdRecurso")
	private  int recurso ;
	
	@Column(name = "HoraIni")
	private  int horaIni ;

	@Column(name = "Duracion")
	private  int duracion ;

	@Column(name = "IdEvento",updatable=false)
	private  int evento;

	@Column(name = "IdPersona",updatable=false)
	private  int persona ;

	

	public int getPersona() {
		return persona;
	}

	public void setPersona(int persona) {
		this.persona = persona;
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

	public void setRecurso(int recurso) {
		this.recurso = recurso;
	}

	public int getEvento() {
		return evento;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}

	public int getRecurso() {
		return recurso;
	}

	
}
