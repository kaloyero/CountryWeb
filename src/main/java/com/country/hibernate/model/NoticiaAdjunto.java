package com.country.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "noticiaadjuntos", catalog = "country")
public class NoticiaAdjunto implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdNoticiaAdjunto", unique = true, nullable = false)
	private int id;
	
	@Column(name = "IdNoticia")
	private int noticia;

	@Column(name = "Adjunto")
	private String adjunto;

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

	public String getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(String adjunto) {
		this.adjunto = adjunto;
	}

	
}
