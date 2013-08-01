package com.country.form;


public class TipoInfraccionForm extends TipoForm  {

	private ConceptoForm concepto;

	private String fechaIni;
	
	private String fechaFin;

	public ConceptoForm getConcepto() {
		return concepto;
	}

	public void setConcepto(ConceptoForm concepto) {
		this.concepto = concepto;
	}

	public String getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
}
