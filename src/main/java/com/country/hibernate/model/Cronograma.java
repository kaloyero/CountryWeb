package com.country.hibernate.model;

import java.io.Serializable;

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
@Table(name = "ActividadCronograma", catalog = "country")
public class Cronograma implements Serializable{
	
	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdCronograma", unique = true, nullable = false)
	private int id;
	
	@Column(name = "DiaSemana")
	private  int diaSemana ;
	
	@Column(name = "HoraIni")
	private  int horaInicio ;
	
	@Column(name = "Duracion")
	private  int duracion ;
	
    @OneToOne(fetch=FetchType.LAZY )
    @JoinColumn(name="IdActividad")	
	private Actividad actividad;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Actividad getActividad() {
		return actividad;
	}
	
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	
}
