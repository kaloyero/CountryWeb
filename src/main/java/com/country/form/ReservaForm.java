package com.country.form;

public class ReservaForm extends Form {

	private  Integer id = 0;
	private  String fecha ;
	private  String descripcion ;
	private  int recursoId ;
	private  int personId;
	private  int eventoId=0;
	private  RecursoForm recurso ;
	private  PersonaForm persona;
	private  EventoForm evento;
	private  Integer horaIni ;
	private  Integer minutosIni ;
	private  Integer duracion ;
	private boolean envioAdm=false;
	
	
	public Integer getMinutosIni() {
		return minutosIni;
	}
	public void setMinutosIni(Integer minutosIni) {
		this.minutosIni = minutosIni;
	}
	public boolean isEnvioAdm() {
		return envioAdm;
	}
	public void setEnvioAdm(boolean envioAdm) {
		this.envioAdm = envioAdm;
	}
	public RecursoForm getRecurso() {
		return recurso;
	}
	public void setRecurso(RecursoForm recurso) {
		this.recurso = recurso;
	}
	public EventoForm getEvento() {
		return evento;
	}
	public void setEvento(EventoForm evento) {
		this.evento = evento;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getHoraIni() {
		return horaIni;
	}
	public void setHoraIni(Integer horaIni) {
		this.horaIni = horaIni;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public int getRecursoId() {
		return recursoId;
	}
	public void setRecursoId(int recursoId) {
		this.recursoId = recursoId;
	}
	public int getEventoId() {
		return eventoId;
	}
	public void setEventoId(int eventoId) {
		this.eventoId = eventoId;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public PersonaForm getPersona() {
		return persona;
	}
	public void setPersona(PersonaForm persona) {
		this.persona = persona;
	}


	
}
