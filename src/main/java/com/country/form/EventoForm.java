package com.country.form;


public class EventoForm extends Form  {

	private int id =0;
	private  String descripcion ;
	private  String fecha ;
	private Integer hourIni;
	private  String horaHasta;
	private String nombre;
	private int cupo;
	private int recurso;
	private int integrante;
	private String integranteNombre;
	ConceptoForm concepto;
	
	
	public String getHoraHasta() {
		return horaHasta;
	}


	public void setHoraHasta(String horaHasta) {
		this.horaHasta = horaHasta;
	}


	public ConceptoForm getConcepto() {
		return concepto;
	}


	public void setConcepto(ConceptoForm concepto) {
		this.concepto = concepto;
	}


	public int getIntegrante() {
		return integrante;
	}


	public void setIntegrante(int integrante) {
		this.integrante = integrante;
	}


	public String getIntegranteNombre() {
		return integranteNombre;
	}


	public void setIntegranteNombre(String integranteNombre) {
		this.integranteNombre = integranteNombre;
	}


	public int getRecurso() {
		return recurso;
	}


	public void setRecurso(int recurso) {
		this.recurso = recurso;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public int getCupo() {
		return cupo;
	}


	public void setCupo(int cupo) {
		this.cupo = cupo;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Integer getHourIni() {
		return hourIni;
	}


	public void setHourIni(Integer hourIni) {
		this.hourIni = hourIni;
	}
	
	

}
