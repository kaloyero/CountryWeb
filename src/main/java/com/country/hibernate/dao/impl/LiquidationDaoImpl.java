package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.LiquidationDao;
import com.country.hibernate.model.Liquidacion;

@Repository("liquidationDao")
public class LiquidationDaoImpl extends GenericDaoImpl<Liquidacion, Integer> implements LiquidationDao{

	@Override
	protected Class<Liquidacion> getEntityClass() {
		return Liquidacion.class;
	}

    public void update(Liquidacion liquidacion) {
    	  getSession().update(liquidacion);
      }

}
