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
@Table(name = "recursoExcepciones", catalog = "country")
public class RecursoExcepcion implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public RecursoExcepcion() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdExcepcion", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "Fecha")
	private  Date fecha ;
	
	@Column(name = "HoraIni")
	private  int horaIni ;

	@Column(name = "Duracion")
	private  int duracion ;

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="IdRecurso",updatable = true, insertable = true)	
	private  Recurso recurso ;

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

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	

}
