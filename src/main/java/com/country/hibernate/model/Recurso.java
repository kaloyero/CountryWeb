package com.country.hibernate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recursos", catalog = "country")
public class Recurso implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Recurso() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdRecurso", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "Nombre")
	private  String nombre ;
	
	@Column(name = "Descripcion")
	private  String descripcion ;
	
	@Column(name = "MaxTiempoReserv")
	private  Date maxTiempoReserv ;
	
    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="IdTipoRecurso",updatable = true, insertable = true)	
	private  TipoRecurso tipoRecurso ;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdConcepto",updatable = true, insertable = true)	
	private Concepto concepto;

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="IdReserva",updatable = true, insertable = true , nullable = true)
	private List <Reserva> reservas;

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="IdExcepcion",updatable = true, insertable = true , nullable = true)
	private List <RecursoExcepcion> excepciones;

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="IdDisponibilidad",updatable = true, insertable = true , nullable = true)
	private List <RecursoDisponibilidad> disponibilidad;

    
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public List<RecursoExcepcion> getExcepciones() {
		return excepciones;
	}

	public void setExcepciones(List<RecursoExcepcion> excepciones) {
		this.excepciones = excepciones;
	}

	public List<RecursoDisponibilidad> getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(List<RecursoDisponibilidad> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getMaxTiempoReserv() {
		return maxTiempoReserv;
	}

	public void setMaxTiempoReserv(Date maxTiempoReserv) {
		this.maxTiempoReserv = maxTiempoReserv;
	}

	public TipoRecurso getTipoRecurso() {
		return tipoRecurso;
	}

	public void setTipoRecurso(TipoRecurso tipoRecurso) {
		this.tipoRecurso = tipoRecurso;
	}

	public Concepto getConcepto() {
		return concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}
	
	
}
