package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.hibernate.dao.LiquidationChargeDao;
import com.country.hibernate.model.LiquidacionCargo;
import com.country.services.LiquidationChargeManager;

@Service("liquidationChargeManager")
public class LiquidationChargeManagerImpl extends AbstractManagerImpl<LiquidacionCargo> implements LiquidationChargeManager{

	@Autowired
    private LiquidationChargeDao liquidationChargeDao;

	protected GenericDao<LiquidacionCargo, Integer> getDao() {
		return liquidationChargeDao;
	}
	
	public LiquidacionCargo findById(Integer id) {
		LiquidacionCargo dto = liquidationChargeDao.findById(id);
		return dto;
	}
	
	@Transactional
	public void save(LiquidacionCargo dto) {
		
		//TODO
		
	}
	
	@Transactional
	public void update(LiquidacionCargo dto) {
		
		//TODO

	}
	
}
