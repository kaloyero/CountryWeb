package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.hibernate.dao.PeriodDao;
import com.country.hibernate.model.Periodo;
import com.country.services.PeriodManager;

@Service("periodManager")
public class PeriodManagerImpl extends AbstractManagerImpl<Periodo> implements PeriodManager{

	@Autowired
    private PeriodDao periodDao;

	protected GenericDao<Periodo, Integer> getDao() {
		return periodDao;
	}
	
	public Periodo findById(Integer id) {
		Periodo dto = periodDao.findById(id);
		return dto;
	}
	
	@Transactional
	public void save(Periodo dto) {
		
		//TODO
		
	}
	
	@Transactional
	public void update(Periodo dto) {
		
		//TODO

	}
	
}
