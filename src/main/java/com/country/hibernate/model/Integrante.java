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
@Table(name = "Integrantes", catalog = "country")
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

    @OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdUnidad",updatable = true, insertable = true)	
	private Unidad unidad;
    
//    @ManyToMany(fetch=FetchType.LAZY)
//    @BatchSize(size = 10)
//    @JoinTable(name = "IntegranteActividades", catalog = "country", joinColumns = {@JoinColumn(name = "IdIntegrante", nullable = false, updatable = false,insertable = false) }, 
//			inverseJoinColumns = { @JoinColumn(name = "IdActividad", nullable = false, updatable = false,insertable = false) })
//	private  List <Actividad> activities ;
    
    
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
