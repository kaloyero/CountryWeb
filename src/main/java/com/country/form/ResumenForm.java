package com.country.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ResumenForm extends Form  {


	private int eventosActivosTotal;
	private int actividaddesTotal;
	private int actividaddesTotalUnidad;
	private int eventosInscriptosTotal;
	private int reservasAbiertasTotal;
	private int reservasAbiertasUnidadTotal;
	private int reclamosAbiertosTotal;
	private int reclamosCerradosTotal;
	private int infraccionesUnidadTotal;
	private List integrantesByUnidad;
	private List vehiculosByUnidad;
	private List mascotasByUnidad;
	private int avisosTotal;
	
	public ResumenForm(int eventCreatedByPerson,
			int eventoInscriptoByIntegrante, Integer reserveNumByPerson,
			Integer reserveNumByUnit, int numReclamosAbiertos,
			int numReclamosCerrados, Integer numInfraccionesByUnidad,
			Integer numAvisosByPerson,Integer actividadesByPerson,Integer actividadesByUnidad,List integrantes,List vehiculos,List mascotas) {
		
		this.setEventosActivosTotal(eventCreatedByPerson);
		this.setEventosInscriptosTotal(eventoInscriptoByIntegrante);
		this.setReservasAbiertasTotal(reserveNumByPerson);
		this.setReservasAbiertasUnidadTotal(reserveNumByUnit);
		this.setReclamosAbiertosTotal(numReclamosAbiertos);
		this.setReclamosCerradosTotal(numReclamosCerrados);
		this.setInfraccionesUnidadTotal(numInfraccionesByUnidad);
		this.setAvisosTotal(numAvisosByPerson);
		this.setActividaddesTotal(actividadesByPerson);
		this.setActividaddesTotalUnidad(actividadesByUnidad);
		this.setIntegrantesByUnidad(integrantes);
		this.setVehiculosByUnidad(vehiculos);
		this.setMascotasByUnidad(mascotas);
		
	}
	public int getEventosActivosTotal() {
		return eventosActivosTotal;
	}
	public void setEventosActivosTotal(int eventosActivosTotal) {
		this.eventosActivosTotal = eventosActivosTotal;
	}
	public int getEventosInscriptosTotal() {
		return eventosInscriptosTotal;
	}
	public void setEventosInscriptosTotal(int eventosInscriptosTotal) {
		this.eventosInscriptosTotal = eventosInscriptosTotal;
	}
	public int getReservasAbiertasTotal() {
		return reservasAbiertasTotal;
	}
	public void setReservasAbiertasTotal(int reservasAbiertasTotal) {
		this.reservasAbiertasTotal = reservasAbiertasTotal;
	}
	public int getReservasAbiertasUnidadTotal() {
		return reservasAbiertasUnidadTotal;
	}
	public void setReservasAbiertasUnidadTotal(int reservasAbiertasUnidadTotal) {
		this.reservasAbiertasUnidadTotal = reservasAbiertasUnidadTotal;
	}
	public int getReclamosAbiertosTotal() {
		return reclamosAbiertosTotal;
	}
	public void setReclamosAbiertosTotal(int reclamosAbiertosTotal) {
		this.reclamosAbiertosTotal = reclamosAbiertosTotal;
	}
	public int getReclamosCerradosTotal() {
		return reclamosCerradosTotal;
	}
	public void setReclamosCerradosTotal(int reclamosCerradosTotal) {
		this.reclamosCerradosTotal = reclamosCerradosTotal;
	}
	public int getInfraccionesUnidadTotal() {
		return infraccionesUnidadTotal;
	}
	public void setInfraccionesUnidadTotal(int infraccionesUnidadTotal) {
		this.infraccionesUnidadTotal = infraccionesUnidadTotal;
	}
	public int getAvisosTotal() {
		return avisosTotal;
	}
	public void setAvisosTotal(int avisosTotal) {
		this.avisosTotal = avisosTotal;
	}
	public int getActividaddesTotal() {
		return actividaddesTotal;
	}
	public void setActividaddesTotal(int actividaddesTotal) {
		this.actividaddesTotal = actividaddesTotal;
	}
	public int getActividaddesTotalUnidad() {
		return actividaddesTotalUnidad;
	}
	public void setActividaddesTotalUnidad(int actividaddesTotalUnidad) {
		this.actividaddesTotalUnidad = actividaddesTotalUnidad;
	}
	public List getIntegrantesByUnidad() {
		return integrantesByUnidad;
	}
	public void setIntegrantesByUnidad(List integrantesByUnidad) {
		this.integrantesByUnidad = integrantesByUnidad;
	}
	public List getVehiculosByUnidad() {
		return vehiculosByUnidad;
	}
	public void setVehiculosByUnidad(List vehiculosByUnidad) {
		this.vehiculosByUnidad = vehiculosByUnidad;
	}
	public List getMascotasByUnidad() {
		return mascotasByUnidad;
	}
	public void setMascotasByUnidad(List mascotasByUnidad) {
		this.mascotasByUnidad = mascotasByUnidad;
	}

	
	

}
