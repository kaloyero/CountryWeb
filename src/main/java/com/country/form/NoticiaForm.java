package com.country.form;

import java.util.HashMap;
import java.util.Map;


public class NoticiaForm extends Form  {

	private int id =0;
	private String titulo;
	private String texto;
	private String estado;
	private int categoria;
	private String fecha;
	private String fechaDesde;
	private String fechaHasta;
	private Map<Integer, String> adjuntos = new HashMap<Integer, String>();

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public String getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public Map<Integer, String> getAdjuntos() {
		return adjuntos;
	}
	public void setAdjuntos(Map<Integer, String> adjuntos) {
		this.adjuntos = adjuntos;
	}

	
	
}
