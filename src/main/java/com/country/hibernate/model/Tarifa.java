package com.country.hibernate.model;

import java.io.Serializable;
import java.util.Date;

public class Tarifa implements Serializable{
	
	private  int id ;
	private  double importe ;
	private  Date fechaComienzo ;
	private  Date fechaFin ;
	private  Concepto concepto ;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getFechaComienzo() {
		return fechaComienzo;
	}
	
	public void setFechaComienzo(Date fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}
	
	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public Concepto getConcepto() {
		return concepto;
	}
	
	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}


}
