package com.country.form;

public class ReservaForm extends Form {

	private  Integer id = 0;
	private  String fecha ;
	private  String descripcion ;
	private  int recursoId ;
	private  int integranteId;
	private  int eventoId=0;
	private  RecursoForm recurso ;
	private  IntegranteForm integrante;
	private  EventoForm evento;
	private  Integer horaIni ;
	private  Integer duracion ;

	public RecursoForm getRecurso() {
		return recurso;
	}
	public void setRecurso(RecursoForm recurso) {
		this.recurso = recurso;
	}
	public IntegranteForm getIntegrante() {
		return integrante;
	}
	public void setIntegrante(IntegranteForm integrante) {
		this.integrante = integrante;
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
	public int getIntegranteId() {
		return integranteId;
	}
	public void setIntegranteId(int integranteId) {
		this.integranteId = integranteId;
	}
	public int getEventoId() {
		return eventoId;
	}
	public void setEventoId(int eventoId) {
		this.eventoId = eventoId;
	}


	
}
