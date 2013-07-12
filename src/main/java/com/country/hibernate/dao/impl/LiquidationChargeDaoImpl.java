package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.LiquidationChargeDao;
import com.country.hibernate.model.LiquidacionCargo;

@Repository("liquidationChargeDao")
public class LiquidationChargeDaoImpl extends GenericDaoImpl<LiquidacionCargo, Integer> implements LiquidationChargeDao{

	@Override
	protected Class<LiquidacionCargo> getEntityClass() {
		return LiquidacionCargo.class;
	}

    public void update(LiquidacionCargo liquidacionCargo) {
    	  getSession().update(liquidacionCargo);
      }

}
