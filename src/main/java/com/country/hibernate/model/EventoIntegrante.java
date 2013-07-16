package com.country.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EventoParticipantes")
public class EventoIntegrante implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdEventoParticipante", unique = true, nullable = false)	
	private int id;
	
	@Column(name = "IdEvento")
	private int evento;
	
	@Column(name = "IdIntegrante")
	private int integrante;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEvento() {
		return evento;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}

	public int getIntegrante() {
		return integrante;
	}

	public void setIntegrante(int integrante) {
		this.integrante = integrante;
	}

	
}
