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
@Table(name = "mensajedetalles", catalog = "country")
public class MensajeDetalles implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdMensajeDetalle", unique = true, nullable = false)
	private int id;
	
	@Column(name = "IdMensaje")
	private int mensaje;

	@Column(name = "Mensaje")
	private String mensajeDetalle;

	@Column(name = "Fecha")
	private Date fecha;
	
	@Column(name = "ModoMensaje")
	private String modoMensaje;
	
	public String getModoMensaje() {
		return modoMensaje;
	}

	public void setModoMensaje(String modoMensaje) {
		this.modoMensaje = modoMensaje;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMensaje() {
		return mensaje;
	}

	public void setMensaje(int mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensajeDetalle() {
		return mensajeDetalle;
	}

	public void setMensajeDetalle(String mensajeDetalle) {
		this.mensajeDetalle = mensajeDetalle;
	}
	
	
}
