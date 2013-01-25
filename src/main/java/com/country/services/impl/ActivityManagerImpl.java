package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.hibernate.dao.ActivityDao;
import com.country.hibernate.dao.ScheduleDao;
import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Cronograma;
import com.country.services.ActivityManager;

@Service("activityManager")
public class ActivityManagerImpl extends AbstractManagerImpl<Actividad> implements ActivityManager{

	@Autowired
    private ActivityDao activityDao;
	@Autowired
    private ScheduleDao scheduleDao;
	
	protected GenericDao<Actividad, Integer> getDao() {
		return activityDao;
	}
	
	@Transactional
	public Actividad findById(Integer id) {
		Actividad act = activityDao.findById(id);
		act.getAsignaciones().size();
		act.getCronogramas().size();
		act.getIntegrants().size();
		return act;
	}

//	public void save(Actividad dto) {
//		activityDao.save(dto);
//	}
	
	public void update(Actividad dto) {
		activityDao.saveOrUpdate(dto);
		
		List<Cronograma> listCrono = scheduleDao.findAllByProperty("actividad.id", dto.getId());
		for (Cronograma cronograma : listCrono) {
			boolean delete = true;
			for (Cronograma crono : dto.getCronogramas()) {
				if (crono.getId() == cronograma.getId() ){
					delete = false;
				}
			}
			if (delete){
				scheduleDao.delete(cronograma);
			}
		}
	}

	public List<Actividad> findAllByActivityName(String name) {
		List<Actividad> list = new ArrayList<Actividad>();
		list = activityDao.findAllByProperty("nombre", name);
		return list;
	}

}
