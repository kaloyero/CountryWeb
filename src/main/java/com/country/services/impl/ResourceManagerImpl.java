package com.country.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.DateUtil;
import com.country.common.GenericDao;
import com.country.form.RecursoForm;
import com.country.hibernate.dao.PriceDao;
import com.country.hibernate.dao.ResourceAvaiableDao;
import com.country.hibernate.dao.ResourceDao;
import com.country.hibernate.model.Recurso;
import com.country.hibernate.model.RecursoDisponibilidad;
import com.country.hibernate.model.Reserva;
import com.country.hibernate.model.Tarifa;
import com.country.mappers.RecursoMapper;
import com.country.services.PriceManager;
import com.country.services.ReserveManager;
import com.country.services.ResourceAvaiableManager;
import com.country.services.ResourceManager;

@Service("resourceManager")
public class ResourceManagerImpl extends AbstractManagerImpl<Recurso> implements ResourceManager{

	@Autowired
    private PriceManager priceManager;
	
	@Autowired
    private ResourceAvaiableManager resourceAvaiableManager;
	
	@Autowired
    private ReserveManager reserveManager;
	
	@Autowired
    private ResourceDao resourceDao;
	
	@Autowired
    private ResourceAvaiableDao resourceAvaiableDao;
	
	@Autowired
    private PriceDao priceDao;
	
	protected GenericDao<Recurso, Integer> getDao() {
		return resourceDao;
	}
	@Transactional
	public Recurso findById(Integer id) {
		Recurso dto = resourceDao.findById(id);
		return dto;
	}
	
	@Transactional
	public int save(RecursoForm form) {
// 		TODO 	Agregar Asignacion
		
		Recurso dto = RecursoMapper.getRecurso(form);
		
		int id = 0;		
		id = resourceDao.save(dto);
		
		//Guarda el importe
		Tarifa price = new Tarifa();
		price.setConcepto(dto.getConcepto().getId());
		price.setImporte(form.getImporte());
		price.setFechaComienzo(dto.getConcepto().getFechaComienzo());
		priceDao.save(price);		


		//Agrego la disponibilidad
		for (RecursoDisponibilidad recDispo : RecursoMapper.getRecursoDisponibilidad(form)) {
			recDispo.setRecurso(id);
			resourceAvaiableDao.save(recDispo);
		}
		
		return id;
	}
	
	@Transactional	
	public void update(RecursoForm form) {
		
		Recurso dto = RecursoMapper.getRecurso(form);
		//La lista de recursos q viene del form
		List<RecursoDisponibilidad> recursoDispoList =  RecursoMapper.getRecursoDisponibilidad(form);
		
		/* Actualizo los horarios disponible */
		List<RecursoDisponibilidad> listRecDispo = resourceAvaiableDao.findAllByProperty("recurso", form.getId());

		
		for (RecursoDisponibilidad recDispo : recursoDispoList) {
			boolean insert = true;
			for (RecursoDisponibilidad recDispoOld : listRecDispo) {
					
				if (recDispo.getDiaSemana() == recDispoOld.getDiaSemana() && recDispo.getHoraIni() == recDispoOld.getHoraIni()){
					insert = false;
				}
			}
			if (insert){
				resourceAvaiableDao.save(recDispo);
			}			
		}
		
		//Borro los dias q ya no estan
		for (RecursoDisponibilidad recDispo : listRecDispo) {
			boolean delete = true;
			for (RecursoDisponibilidad recDispoOut : recursoDispoList) {
				if (recDispo.getDiaSemana() == recDispoOut.getDiaSemana() && recDispo.getHoraIni() == recDispoOut.getHoraIni() ){
					delete = false;
				}
			}
			if (delete){
				resourceAvaiableDao.delete(recDispo);
			}
		}		
		
		/* Actualizo la tarifa */
		//Agarro la tarifa que viene del form
		Tarifa price = new Tarifa();
		price.setConcepto(dto.getConcepto().getId());
		price.setImporte(form.getImporte());
		//TODO setear la fecha correspondiente
		price.setFechaComienzo(new Date());
		
		//si es igual a la ultima no la actualizo, sino la agrego a la lista
		Tarifa tarifaUltima = priceManager.getLastPriceByConcept(dto.getConcepto().getId());
		
		if (tarifaUltima == null || price.getImporte() != tarifaUltima.getImporte()){
			priceDao.save(price);	
		}
		
		resourceDao.update(dto);
		
	}
	
	
	public RecursoForm getResourceForm(Integer id){
		Recurso dto = resourceDao.findById(id);
		Tarifa tarifa = priceManager.getLastPriceByConcept(dto.getConcepto().getId());
		List<RecursoDisponibilidad> listDispoRec = resourceAvaiableManager.findResourcesAvaiableById(id); 
		
		RecursoForm form = (RecursoForm) RecursoMapper.getForm(dto,tarifa.getImporte(),listDispoRec);
		
		return form;
	}

	public List<RecursoForm> listAllResourceForm(){
		List<RecursoForm> listaRecursosForm = new ArrayList<RecursoForm>();
		for (Recurso recurso : listAll()) {
			Tarifa tarifa = priceManager.getLastPriceByConcept(recurso.getConcepto().getId());
			if (tarifa != null){
				listaRecursosForm.add(RecursoMapper.getForm(recurso,tarifa.getImporte(),null));	
			} else {
				listaRecursosForm.add(RecursoMapper.getForm(recurso,0,null));	
			}
			
		}

		
		return listaRecursosForm;
	}
	
	public boolean checkReserveResourceAvaibility(int resource, Date fecha,
			int horaIni, int duracion) {
		
		Reserva anterior = reserveManager.findResourceBefore(resource, fecha, horaIni);
		Reserva posterior = reserveManager.findResourceAfter(resource, fecha, horaIni);
		
		Date fechaReservar = DateUtil.sumarHoras(fecha, horaIni);
		
		//ANTERIOR
		boolean responseAnt = false;
		if (anterior != null){
			Date fechaAnt = DateUtil.sumarHoras(anterior.getFecha(), anterior.getHoraIni());
			fechaAnt = DateUtil.sumarHoras(fechaAnt, anterior.getDuracion());
			
			// Si la reserva anterior termina antes de la reserva que quiero hacer devuelve ok
			if (fechaAnt.before(fechaReservar) ){
				responseAnt = true;
			} else {
				//Hay una reserva anterior que se pisa con el horario que quiero reservar
				return false;
			}
		} else {
			responseAnt = true;
		}
		
		//POSTERIOR
		boolean responsePost = false;
		if (posterior != null){
			Date fechaPost = DateUtil.sumarHoras(posterior.getFecha(), posterior.getHoraIni());
			
			// Pregunto si la reserva posterior empieza despues de la hora que empieza la actual reserva 
			if (fechaPost.after(fechaReservar) ){
				//le sumo a la reserva actual la duracion
				fechaReservar = DateUtil.sumarHoras(fechaReservar, duracion);
				// Pregunto si la reserva posterior empieza despues de la hora que empieza la actual reserva con la duracion
				if (fechaPost.after(fechaReservar) ){
					responsePost = true;
				} else {
					//hay una reserva que empieza en ese horario
					return false;
				}
				responseAnt = true;
			} else {
				//hay una reserva que empieza en ese horario
				return false;
			}
		}else {
			responsePost = true;
		}

		if ((responseAnt && responsePost)){
			return true;	
		} 
		
		return false;
		
	}

	public boolean checkReserveResourceDisponibility(int resource, Date fecha,
			int horaIni, int duracion) {
		
		//HORA INICIAL
		Date fechaInicio = DateUtil.sumarHoras(fecha, horaIni);
		//Tomo todos los horarios disponibles en que esta el recurso ese dia.
		List<RecursoDisponibilidad> listaDisponibilidad= resourceAvaiableManager.findResourcesAvaiableByDayOfWeek(resource, DateUtil.getDiaDeLaSemana(fechaInicio));
		boolean disponibleHoraIni = false;
		for (RecursoDisponibilidad disponibilidad : listaDisponibilidad) {
			//Comparo la hra inicial, para saber si esta dentro de los horarios de ese dia.
			if (horaIni >= disponibilidad.getHoraIni() && horaIni <= disponibilidad.getHoraFin()){
				disponibleHoraIni = true;
			}
		}
		if (!disponibleHoraIni){
			//Si sale por aca es porque la hora inicial no esta dentro del horario disponible del recurso.
			return false;
		}
		
		//HORA FINAL
		Date fechaFin = DateUtil.sumarHoras(fechaInicio, duracion);
		//Tomo todos los horarios disponibles en que esta el recurso ese dia.
		listaDisponibilidad= resourceAvaiableManager.findResourcesAvaiableByDayOfWeek(resource, DateUtil.getDiaDeLaSemana(fechaFin));
		boolean disponibleHoraFin = false;
		int horaFin = DateUtil.getHora(fechaFin); 
		for (RecursoDisponibilidad disponibilidad : listaDisponibilidad) {
			//Comparo la hra inicial, para saber si esta dentro de los horarios de ese dia.
			if (horaFin >= disponibilidad.getHoraIni() && horaFin <= disponibilidad.getHoraFin()){
				disponibleHoraFin = true;
			}
		}
		if (!disponibleHoraFin){
			//Si sale por aca es porque la hora inicial no esta dentro del horario disponible del recurso.
			return false;
		}

		if (disponibleHoraIni && disponibleHoraFin){
			return true;
		}
		
		return false;
	}

	public boolean checkReserveResource(int resource, Date fecha,
			int horaIni, int duracion) {
		boolean disponible = false;
		
		if (checkReserveResourceAvaibility(resource, fecha, horaIni, duracion)){
			if (checkReserveResourceDisponibility(resource, fecha, horaIni, duracion)){
				disponible = true;
			} else {
				System.out.println("Para esta reserva el recurso no esta disponible");
			}
		} else {
			System.out.println("El recurso esta reservado para esa fecha");
		}
	
		return disponible;
	}

	public List<RecursoForm> listAllForms() {
		List<RecursoForm> list = new ArrayList<RecursoForm>();
		List<Recurso> recursos = listAll();
		
		for (Recurso recurso : recursos) {
			//Toma la ultima tarifa
			Tarifa tarifa = priceManager.getLastPriceByConcept(recurso.getConcepto().getId());

			RecursoForm form = (RecursoForm) RecursoMapper.getForm(recurso, tarifa.getImporte(),null);
			list.add(form);
		}
		return list;
	}
}
