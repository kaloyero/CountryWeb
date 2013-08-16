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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Empleados")
public class Empleado implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Empleado() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdEmpleado", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "Puesto")
	private  String puesto ;

	@Column(name = "Legajo")
	private  String legajo ;
	
	@Column(name = "fechaIngreso")
	private  Date fecha;
		
	@Column(name = "estado")
	private String estado;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdEmpleadoCategoria",updatable = false, insertable = true)	
	private  EmpleadoCategoria categoria;

	@OneToOne(fetch=FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="IdPersona",updatable = true, insertable = true)	
	private Persona persona;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdUsuario",updatable = true, insertable = true)	
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public EmpleadoCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(EmpleadoCategoria categoria) {
		this.categoria = categoria;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
