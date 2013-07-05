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
@Table(name = "Mensajes")
public class Mensaje implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdMensaje", unique = true, nullable = false)
	private int id;
	
	@Column(name = "Fecha")
	private Date fecha;
	
	@Column(name = "FechaCierre")
	private Date fechaCierre;
	
	@Column(name = "Asunto")
	private String asunto;
	
	@Column(name = "Resolucion")
	private String resolucion;
	
	@Column(name = "Estado")
	private String estado;
	
	@Column(name = "TipoMensaje")
	private String tipo;
	
    @OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdMensajeCategoria")	
	private MensajeCategorias categoria;
    
    @OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdIntegrante")	
	private Integrante integrante;
    

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

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public MensajeCategorias getCategoria() {
		return categoria;
	}

	public void setCategoria(MensajeCategorias categoria) {
		this.categoria = categoria;
	}

	public Integrante getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
}
