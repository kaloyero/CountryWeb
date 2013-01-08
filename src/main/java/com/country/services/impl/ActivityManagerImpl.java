package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.hibernate.dao.ActivityDao;
import com.country.hibernate.dao.ScheduleDao;
import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Cronograma;
import com.country.services.ActivityManager;

@Service("activityManager")
public class ActivityManagerImpl implements ActivityManager{

	@Autowired
    private ActivityDao activityDao;
	@Autowired
    private ScheduleDao scheduleDao;
	
	@Transactional
	public Actividad findById(Integer id) {
		Actividad act = activityDao.findById(id);
		act.getAsignaciones();
		act.getCronogramas();
		act.getIntegrants();
		return act;
	}

	public void save(Actividad dto) {
		activityDao.saveOrUpdate(dto);
	}
	
	public void update(Actividad dto) {
		 activityDao.saveOrUpdate(dto);
	}

	public Integer edit(Actividad dto) {
		//Chequea si existe
		if (dto.getId() != null && activityDao.findById(dto.getId()) !=  null ){
			List<Cronograma> listaScheduleDb =scheduleDao.findAllByProperty("IdActividad", dto.getId());
			List<Cronograma> listaScheduleNew =dto.getCronogramas();

			for (Cronograma cronoDb : listaScheduleDb) {
				boolean exist = false;
				
				for (Cronograma cronoNew : listaScheduleNew) {
					if (cronoDb.getId() == cronoNew.getId() ){
						exist = true;
					}
				}
				if (!exist){
					scheduleDao.delete(cronoDb);
				}
			} 
		}
		
		Integer pk = activityDao.save(dto);
		return pk;
	}
	
	public List<Actividad> listAll() {
		List<Actividad> list = new ArrayList<Actividad>();
		list = activityDao.findAll();
		return list;
	}

	public List<Actividad> listAllPagin() {
		List<Actividad> list = new ArrayList<Actividad>();
		list = activityDao.findAll();
		return list;
	}
	
	public List<Actividad> findAllByActivityName(String name) {
		List<Actividad> list = new ArrayList<Actividad>();
		list = activityDao.findAllByProperty("nombre", name);
		return list;
	}

}
