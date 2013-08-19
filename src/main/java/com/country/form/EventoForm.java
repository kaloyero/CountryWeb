package com.country.form;


public class EventoForm extends Form  {

	private int id =0;
	private  String descripcion ;
	private  String fecha ;
	private Integer hourIni;
	private  int duracion;
	private String nombre;
	private int cupo;
	private int recurso;
	private int personaId;
	private PersonaForm persona;
	ConceptoForm concepto;
	private int cantidadUnidos;
	private String diaSemana;
	private boolean envioAdm=false;
	
	
	
	public int getPersonaId() {
		return personaId;
	}


	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}


	public boolean isEnvioAdm() {
		return envioAdm;
	}


	public void setEnvioAdm(boolean envioAdm) {
		this.envioAdm = envioAdm;
	}


	public int getCantidadUnidos() {
		return cantidadUnidos;
	}


	public void setCantidadUnidos(int cantidadUnidos) {
		this.cantidadUnidos = cantidadUnidos;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


		public ConceptoForm getConcepto() {
		return concepto;
	}


	public void setConcepto(ConceptoForm concepto) {
		this.concepto = concepto;
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
	
	public PersonaForm getPersona() {
		return persona;
	}
	public void setPersona(PersonaForm persona) {
		this.persona = persona;
	}


	public String getDiaSemana() {
		return diaSemana;
	}


	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	
	

}
