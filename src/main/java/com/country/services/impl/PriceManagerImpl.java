package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.hibernate.dao.PriceDao;
import com.country.hibernate.model.Tarifa;
import com.country.services.PriceManager;

@Service("priceManager")
public class PriceManagerImpl extends AbstractManagerImpl<Tarifa> implements PriceManager{

	@Autowired
    private PriceDao priceDao;
	
	protected GenericDao<Tarifa, Integer> getDao() {
		return priceDao;
	}
	
	@Transactional
	public Tarifa findById(Integer id) {
		Tarifa act = priceDao.findById(id);
		return act;
	}
	
	@Transactional
	public Tarifa getLastPriceByConcept(int idConcept){
		Tarifa obj = priceDao.getLastPriceByConcept(idConcept);
		return obj;
	}


}
