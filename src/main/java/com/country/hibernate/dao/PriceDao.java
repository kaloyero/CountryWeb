package com.country.hibernate.dao;

import com.country.common.GenericDao;
import com.country.hibernate.model.Tarifa;

public interface PriceDao extends GenericDao<Tarifa, Integer> {
	
	Tarifa getLastPriceByConcept(int concept);

}
