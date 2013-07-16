package com.country.hibernate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "noticias", catalog = "country")
public class Noticia implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdNoticia", unique = true, nullable = false)
	private int id;
	
	@Column(name = "Titulo")
	private String titulo;

	@Column(name = "Texto")
	private String texto;

	@Column(name = "Estado")
	private String estado;

    @OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdCategoria")	
	private NoticiaCategorias categoria;

	@Column(name = "Fecha")
	private Date fecha;
	
	@Column(name = "PublicaDesde")
	private Date fechaDesde;
	
	@Column(name = "PublicaHasta")
	private Date fechaHasta;

	@OneToMany(fetch=FetchType.LAZY)
	@BatchSize(size = 10)
    @JoinColumn(name="IdNoticia",updatable = false, insertable = false , nullable = true)
	private  List <NoticiaAdjunto> adjuntos ;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public NoticiaCategorias getCategoria() {
		return categoria;
	}

	public void setCategoria(NoticiaCategorias categoria) {
		this.categoria = categoria;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<NoticiaAdjunto> getAdjuntos() {
		return adjuntos;
	}

	public void setAdjuntos(List<NoticiaAdjunto> adjuntos) {
		this.adjuntos = adjuntos;
	}

	
}
