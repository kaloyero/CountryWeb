package com.country.form;

import java.util.Date;

public class TarifaForm extends Form  {

	private  int id ;
	private  double importe ;
	private  Date fechaComienzo ;
	private  Date fechaFin ;
	
	
	public TarifaForm() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getImporte() {
		return importe;
	}


	public void setImporte(double importe) {
		this.importe = importe;
	}


	public Date getFechaComienzo() {
		return fechaComienzo;
	}


	public void setFechaComienzo(Date fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	

}
