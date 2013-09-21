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
@Table(name = "Usuarios")
public class Usuario implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IDUsuario", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "Descripcion")
	private  String descripcion;

	@Column(name = "ClaveAccesoEncriptada",updatable=false)
	private  String clave;

	@Column(name = "ActivoDesde",updatable=false)
	private  Date fechaDesde;

	@Column(name = "ActivoHasta")
	private  Date fechaHasta;

	@Column(name = "NombreUsuario")
	private  String nombreUsuario;

	@Column(name = "ResetPass",updatable=false)
	private  String resetPass;

	@Column(name = "Estado")
	private  String estado;

	@Column(name = "TipoUsuario")
	private  String tipo;

	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getResetPass() {
		return resetPass;
	}

	public void setResetPass(String resetPass) {
		this.resetPass = resetPass;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
