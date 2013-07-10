package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.hibernate.dao.LiquidationDao;
import com.country.hibernate.model.Liquidacion;
import com.country.services.LiquidationManager;

@Service("liquidationManager")
public class LiquidationManagerImpl extends AbstractManagerImpl<Liquidacion> implements LiquidationManager{

	@Autowired
    private LiquidationDao liquidationDao;

	protected GenericDao<Liquidacion, Integer> getDao() {
		return liquidationDao;
	}
	
	public Liquidacion findById(Integer id) {
		Liquidacion dto = liquidationDao.findById(id);
		return dto;
	}
	
	@Transactional
	public void save(Liquidacion dto) {
		
		//TODO
		
	}
	
	@Transactional
	public void update(Liquidacion dto) {
		
		//TODO

	}
	
}
