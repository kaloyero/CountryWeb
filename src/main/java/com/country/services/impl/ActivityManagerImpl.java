package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.hibernate.dao.ActivityDao;
import com.country.hibernate.model.Actividad;
import com.country.services.ActivityManager;

@Service("activityManager")
public class ActivityManagerImpl implements ActivityManager{

	@Autowired
    private ActivityDao activityDao;
	
	public Integer createActivity(Actividad dto){
		
		Integer pk = activityDao.save(dto);
		return pk;
	}

	public Actividad findById(Integer id) {

		Actividad act = activityDao.findById(id);
		return act;
	}
	
}
