package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.hibernate.dao.UnitDao;
import com.country.hibernate.model.Unidad;
import com.country.services.UnitManager;

@Service("unitManager")
public class UnitManagerImpl implements UnitManager{

	@Autowired
    private UnitDao unitDao;
	
	public void save(Unidad dto) {
		unitDao.saveOrUpdate(dto);
	}

	public List<Unidad> listAll() {
		List<Unidad> list = new ArrayList<Unidad>();
		list = unitDao.findAll();
		return list;
	}

	public Unidad findById(Integer id) {
		Unidad dto = unitDao.findById(id);
		return dto;
	}
	
}
