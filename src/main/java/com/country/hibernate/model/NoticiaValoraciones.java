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

@Entity
@Table(name = "NoticiaValoraciones")
public class NoticiaValoraciones implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdNoticiaValoracion", unique = true, nullable = false)
	private int id;
	
	@Column(name = "IdNoticia")
	private int noticia;
	
	@Column(name = "Valoracion")
	private int valoracion;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdIntegrante")	
	private Integrante integrante;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoticia() {
		return noticia;
	}

	public void setNoticia(int noticia) {
		this.noticia = noticia;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public Integrante getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}
	
}
