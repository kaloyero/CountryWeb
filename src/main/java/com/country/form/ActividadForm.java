package com.country.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Instructor;

public class ActividadForm {
	private String name = null;
	private String descripcion = null;
	private String fechaInicio = null;
	private int importe = 0;
	List<Integer> instructores = new ArrayList();
	private Map<Integer, String[]> dias = new HashMap<Integer, String[]>();
	String[] lunes = {};
	String[] martes = {};
	String[] miercoles = {};
	String[] jueves = {};
	String[] viernes = {};
	String[] sabado = {};
	String[] domingo = {};
	private List<String> horas = new ArrayList<String>();

	public ActividadForm() {
		instructores.add(2);
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

	public String[] getLunes() {
		return lunes;
	}

	public void setLunes(String[] lunes) {
		this.lunes = lunes;
	}

	public String[] getMartes() {
		return martes;
	}

	public void setMartes(String[] martes) {
		this.martes = martes;
	}

	public String[] getMiercoles() {
		return miercoles;
	}

	public void setMiercoles(String[] miercoles) {
		this.miercoles = miercoles;
	}

	public String[] getJueves() {
		return jueves;
	}

	public void setJueves(String[] jueves) {
		this.jueves = jueves;
	}

	public String[] getViernes() {
		return viernes;
	}

	public void setViernes(String[] viernes) {
		this.viernes = viernes;
	}

	public String[] getSabado() {
		return sabado;
	}

	public void setSabado(String[] sabado) {
		this.sabado = sabado;
	}

	public String[] getDomingo() {
		return domingo;
	}

	public void setDomingo(String[] domingo) {
		this.domingo = domingo;
	}

	public List getHoras() {
		return horas;
	}

	public void setHoras(List horas) {
		this.horas = horas;
	}

	public List<Integer> getInstructores() {
		return instructores;
	}

	public void setInstructores(List<Integer> instructores) {
		this.instructores = instructores;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Map<Integer, String[]> getDias() {
		return dias;
	}

	public void setDias(Map<Integer, String[]> dias) {
		this.dias = dias;
	}

}
