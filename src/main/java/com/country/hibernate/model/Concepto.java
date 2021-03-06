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
@Table(name = "Conceptos")
public class Concepto implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Concepto() {
	}
	public Concepto(int id) {
		super();
		this.id = id;
	}

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdConcepto", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "Descripcion")
	private  String descripcion ;
	
	@Column(name = "FechaIni")
	private  Date fechaComienzo ;
	
	@Column(name = "FechaFin")
	private  Date fechaFin ;
	
	@Column(name = "Nombre")
	private String nombre;
	
//    @OneToMany(fetch=FetchType.EAGER)
//    @JoinColumn(name="IdConcepto",updatable = false, insertable = false , nullable = true)
//	private  List <Tarifa> tarifas ;

	
    
	public int getId() {
		return id;
	}

//	public List<Tarifa> getTarifas() {
//		return tarifas;
//	}

//	public void setTarifas(List<Tarifa> tarifas) {
//		this.tarifas = tarifas;
//	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setId(int id) {
		this.id = id;
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
	
}
