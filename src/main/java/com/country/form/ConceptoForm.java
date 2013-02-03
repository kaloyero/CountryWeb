package com.country.form;

import java.util.Date;
import java.util.List;




public class ConceptoForm extends Form  {

private  int id ;
	
	private  String descripcion ;
	private  String fechaComienzo ;
	private String nombre;
	private double importe;
	private  List <TarifaForm> tarifas ;
	
	
	public ConceptoForm() {
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


	public String getFechaComienzo() {
		return fechaComienzo;
	}


	public void setFechaComienzo(String fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
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


	public List<TarifaForm> getTarifas() {
		return tarifas;
	}


	public void setTarifas(List<TarifaForm> tarifas) {
		this.tarifas = tarifas;
	}
	

}
