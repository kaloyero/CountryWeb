package com.country.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class RecursoForm extends Form  {

	private  int id =0;
	
	private  String descripcion ;
	private String nombre;
	private int idConcepto;
	private double importe;
	private Integer maxTiempoReserva;
	private List< Map<Integer, Integer>> reservas = new ArrayList();
	private String disponibilidades="";
	private String disponibilidadesDivididas="";
	private int tipoRecurso ;
	private String tipoRecursoDesc ;
	
	
	public String getTipoRecursoDesc() {
		return tipoRecursoDesc;
	}
	public void setTipoRecursoDesc(String tipoRecursoDesc) {
		this.tipoRecursoDesc = tipoRecursoDesc;
	}
	public int getId() {
		return id;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Integer getMaxTiempoReserva() {
		return maxTiempoReserva;
	}
	public void setMaxTiempoReserva(Integer maxTiempoReserva) {
		this.maxTiempoReserva = maxTiempoReserva;
	}
	public int getTipoRecurso() {
		return tipoRecurso;
	}
	public void setTipoRecurso(int tipoRecurso) {
		this.tipoRecurso = tipoRecurso;
	}
	public List<Map<Integer, Integer>> getReservas() {
		return reservas;
	}
	public void setReservas(List<Map<Integer, Integer>> reservas) {
		this.reservas = reservas;
	}
	public String getDisponibilidades() {
   		System.out.println("GET"+ disponibilidades);

		return disponibilidades;
	}
	public void setDisponibilidades(String disponibilidades) {
   		System.out.println("SET"+ disponibilidades);

		this.disponibilidades = disponibilidades;
	}
	
	public int getIdConcepto() {
		return idConcepto;
	}
	public void setIdConcepto(int idConcepto) {
		this.idConcepto = idConcepto;
	}
	public String getDisponibilidadesDivididas() {
		return disponibilidadesDivididas;
	}
	public void setDisponibilidadesDivididas(String disponibilidadesDivididas) {
		this.disponibilidadesDivididas = disponibilidadesDivididas;
	}

}
