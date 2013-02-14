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
@Table(name = "recursoDisponibilidades", catalog = "country")
public class RecursoDisponibilidad implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public RecursoDisponibilidad() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdDisponibilidad", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "DiaSemana")
	private  int diaSemana ;
	
	@Column(name = "HoraIni")
	private  int horaIni ;

	@Column(name = "HoraFin")
	private  int horaFin ;

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="IdRecurso",updatable = true, insertable = true)	
	private  Recurso recurso ;

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

	public int getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(int horaIni) {
		this.horaIni = horaIni;
	}

	public int getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(int horaFin) {
		this.horaFin = horaFin;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    
    
    
    
    

}
