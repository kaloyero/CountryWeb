package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.ActividadForm;
import com.country.hibernate.dao.ActivityDao;
import com.country.hibernate.dao.AsignationDao;
import com.country.hibernate.dao.ConceptDao;
import com.country.hibernate.dao.PriceDao;
import com.country.hibernate.dao.ScheduleDao;
import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Asignacion;
import com.country.hibernate.model.Cronograma;
import com.country.hibernate.model.Tarifa;
import com.country.mappers.ActividadMapper;
import com.country.services.ActivityManager;
import com.country.services.PriceManager;

@Service("activityManager")
public class ActivityManagerImpl extends AbstractManagerImpl<Actividad> implements ActivityManager{

	@Autowired
    private ActivityDao activityDao;

	@Autowired
    private ConceptDao conceptDao;

	@Autowired
    private ScheduleDao scheduleDao;
	
	@Autowired
    private PriceDao priceDao;

	@Autowired
    private AsignationDao asignationDao;

	@Autowired
    private PriceManager priceManager;

	
	protected GenericDao<Actividad, Integer> getDao() {
		return activityDao;
	}
	
	@Transactional
	private Actividad findById(Integer id) {
		Actividad act = activityDao.findById(id);
		act.getCronogramas().size();
		act.getAsignaciones().size();
//		act.getIntegrants().size();
		return act;
	}

	@Transactional
	public ActividadForm findFormById(Integer id) {
		ActividadForm form = new ActividadForm();
		
		Actividad dto = findById(id);
		Tarifa tarifa = priceManager.getLastPriceByConcept(dto.getConcepto().getId());
		
		form = (ActividadForm) ActividadMapper.getForm(dto,tarifa);
		
		return form;
	
	}
	
	public List<Asignacion> findAsignacionByIdAct(Integer id) {
		List<Asignacion> list = (List<Asignacion>) asignationDao.findAllByProperty("actividad.id",id);
		return list;
	}
	

	@Transactional
	public int save(Actividad dto, Double tarifa) {		
		int id = 0;		
		id = activityDao.save(dto);
		
		
		for (Asignacion asignacion : dto.getAsignaciones()) {
			asignacion.getActividad().setId(id);
			asignationDao.save(asignacion);
		} 
		scheduleDao.saveList(dto.getCronogramas());
		Tarifa price = new Tarifa();

		price.setConcepto(dto.getConcepto().getId());
		price.setImporte(tarifa);
		price.setFechaComienzo(dto.getFechaComienzo());
		priceDao.save(price);		

		return id;
	}
	
	@Transactional	
	//public void update(Actividad dto, List<Asignacion> asignaciones, Double tarifa) {
	public void update(Actividad dto, List<Asignacion> asignaciones, Double tarifa) {
		List<Cronograma> listCrono = scheduleDao.findAllByProperty("actividad.id", dto.getId());

		for (Cronograma crono : dto.getCronogramas()) {
			boolean insert = true;
			for (Cronograma cronograma : listCrono) {
					
				if (crono.getDiaSemana() == cronograma.getDiaSemana() && crono.getHoraInicio() == cronograma.getHoraInicio()){
					insert = false;
				}
			}
			if (insert){
				scheduleDao.save(crono);
			}			
		}
		
		//Borro los cronogramas q ya no estan
		for (Cronograma cronograma : listCrono) {
			boolean delete = true;
			for (Cronograma crono : dto.getCronogramas()) {
				if (crono.getDiaSemana() == cronograma.getDiaSemana() && crono.getHoraInicio() == cronograma.getHoraInicio() ){
					delete = false;
				}
			}
			if (delete){
				scheduleDao.delete(cronograma);
			}
		}		
		//Agarro la tarifa que viene del form
		Tarifa price = new Tarifa();
		price.setConcepto(dto.getConcepto().getId());
		price.setImporte(tarifa);
		price.setFechaComienzo(dto.getFechaComienzo());

		//si es igual a la ultima no la actualizo, sino la agrego a la lista
		Tarifa tarifaUltima = priceDao.getLastPriceByConcept(dto.getConcepto().getId());
		
		if (tarifaUltima == null || price.getImporte() != tarifaUltima.getImporte()){
			priceDao.save(price);	
		}
		
		for (Asignacion asign : asignaciones) {
			asignationDao.update(asign);
		}

		activityDao.update(dto);
		
	}

	@Transactional
	public List<Actividad> findAllByActivityName(String name) {
		List<Actividad> list = new ArrayList<Actividad>();
		list = activityDao.findAllByProperty("nombre", name);
		return list;
	}
	
	@Transactional
	public List<Actividad> listAllForBook() {
		List<Actividad> actividades = new ArrayList<Actividad>();
		actividades = activityDao.findAll();
		for (Actividad actividad : actividades) {
			actividad.getCronogramas().size();
		}
		return actividades;
	}

	@Transactional
	public List<ActividadForm> listAllFormsComplete() {
		List<ActividadForm> list = new ArrayList<ActividadForm>();
		List<Actividad> actividades = activityDao.findAll();

		for (Actividad actividad : actividades) {
			//Asignaciones
			if (actividad.getAsignaciones() != null){
				actividad.getAsignaciones().size();	
			}
			//Cronogramas
			actividad.getCronogramas().size();
			//Toma la ultima tarifa
			Tarifa tarifa = priceManager.getLastPriceByConcept(actividad.getConcepto().getId());
			
			ActividadForm form = (ActividadForm) ActividadMapper.getForm(actividad, tarifa);
			list.add(form);
		}
		
		return list;
	}

	
}
