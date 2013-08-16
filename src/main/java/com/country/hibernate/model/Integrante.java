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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "Integrantes")
public class Integrante implements Serializable {
	
	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdIntegrante", unique = true, nullable = false)	
	private int id;
	
	@Column(name = "Tipo")
	private String tipo;
	
	@OneToOne(fetch=FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="IdPersona",updatable = true, insertable = true)	
	private Persona persona;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdUsuario",updatable = false, insertable = true)	
	private Usuario usuario;
	
    @OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdUnidad",updatable = true, insertable = true)	
	private Unidad unidad;
    
	@Column(name = "estado")
	private String estado; 
	
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

//	public List<Actividad> getActivities() {
//		return activities;
//	}
//
//	public void setActivities(List<Actividad> activities) {
//		this.activities = activities;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	
}
