package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.hibernate.dao.ActivityDao;
import com.country.hibernate.model.Actividad;
import com.country.services.ActivityManager;

@Service("activityManager")
public class ActivityManagerImpl implements ActivityManager{

	@Autowired
    private ActivityDao activityDao;

	public Actividad findById(Integer id) {
		Actividad act = activityDao.findById(id);
		return act;
	}

	public Integer save(Actividad dto) {
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
