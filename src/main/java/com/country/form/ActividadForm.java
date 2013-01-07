package com.country.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActividadForm {
	private Integer id;
	private String nombre = null;
	private String descripcion = null;
	private String fechaInicio = null;
	private double importe = 0;
	List<Integer> instructores = new ArrayList();

	private Map<Integer, List<String>> dias = new HashMap<Integer, List<String>>();
	List<String> lunes = new ArrayList();
	List<String> martes = new ArrayList();
	List<String> miercoles = new ArrayList();
	List<String> jueves = new ArrayList();
	List<String> viernes = new ArrayList();
	List<String> sabado = new ArrayList();
	List<String> domingo = new ArrayList();
	private List<String> horas = new ArrayList<String>();

	public ActividadForm() {
		horas.add("10");
		horas.add("12");
		horas.add("14");
		horas.add("16");
		horas.add("18");
		horas.add("20");

		this.getDias().put(0, this.getDomingo());
		this.getDias().put(1, this.getLunes());
		this.getDias().put(2, this.getMartes());
		this.getDias().put(3, this.getMiercoles());
		this.getDias().put(4, this.getJueves());
		this.getDias().put(5, this.getViernes());
		this.getDias().put(6, this.getSabado());

	}

	public List<String> getLunes() {
		return lunes;
	}

	public void setLunes(List<String> lunes) {
		this.lunes = lunes;
	}

	public List<String> getMartes() {
		return martes;
	}

	public void setMartes(List<String> martes) {
		this.martes = martes;
	}

	public List<String> getMiercoles() {
		return miercoles;
	}

	public void setMiercoles(List<String> miercoles) {
		this.miercoles = miercoles;
	}

	public List<String> getJueves() {
		return jueves;
	}

	public void setJueves(List<String> jueves) {
		this.jueves = jueves;
	}

	public List<String> getViernes() {
		return viernes;
	}

	public void setViernes(List<String> viernes) {
		this.viernes = viernes;
	}

	public List<String> getSabado() {
		return sabado;
	}

	public void setSabado(List<String> sabado) {
		this.sabado = sabado;
	}

	public List<String> getDomingo() {
		return domingo;
	}

	public void setDomingo(List<String> domingo) {
		this.domingo = domingo;
	}

	public void setHoras(List<String> horas) {
		this.horas = horas;
	}

	public List getHoras() {
		return horas;
	}

	public List<Integer> getInstructores() {
		return instructores;
	}

	public void setInstructores(List<Integer> instructores) {
		this.instructores = instructores;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Map<Integer, List<String>> getDias() {
		return dias;
	}

	public void setDias(Map<Integer, List<String>> dias) {
		this.dias = dias;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
