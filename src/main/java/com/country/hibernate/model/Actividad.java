package com.country.hibernate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "actividades", catalog = "country")
public class Actividad implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdActividad", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "Nombre")
	private  String nombre;
	
	@Column(name = "Descripcion")
	private  String descripcion;
	
	@Column(name = "FechaIni")
	private  Date fechaComienzo ;
	
	@Column(name = "FechaFin")
	private  Date fechaFin ;

	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="IdConcepto")	
	private  Concepto  concepto ;
	
	
<<<<<<< HEAD
    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@BatchSize(size = 10)
=======
    
//    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
//    	org.hibernate.annotations.CascadeType.REFRESH,
//    	org.hibernate.annotations.CascadeType.EVICT, 
//    	org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	@OneToMany(cascade={CascadeType.ALL})
>>>>>>> d1a7ed5d02103a7c0096151e95ea2e7c579e2ccb
    @JoinColumn(name="IdActividad",updatable = true, insertable = true , nullable = true)
	private  List <Cronograma> cronogramas ;
	
    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@BatchSize(size = 10)
    @JoinColumn(name="IdActividad",updatable = true, insertable = true , nullable = true)
	private List <Asignacion> asignaciones;

    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @BatchSize(size = 10)
    @JoinTable(name = "IntegranteActividades", catalog = "country", joinColumns = {@JoinColumn(name = "IdActividad", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "IdIntegrante", nullable = false, updatable = false) })
	private  List <Integrante> integrants ;
    
	public List<Integrante> getIntegrants() {
		return integrants;
	}

	public void setIntegrants(List<Integrante> integrants) {
		this.integrants = integrants;
	}

	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	public List<Cronograma> getCronogramas() {
		return cronogramas;
	}

	public void setCronogramas(List<Cronograma> cronogramas) {
		this.cronogramas = cronogramas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getFechaComienzo() {
		return fechaComienzo;
	}

	public void setFechaComienzo(Date fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Concepto getConcepto() {
		return concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}

}
