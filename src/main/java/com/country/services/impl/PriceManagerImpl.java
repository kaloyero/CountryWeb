package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.DateUtil;
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

	
	@Transactional	
	public void updateTarifa(int conceptoId, Double nuevaTarifa) {
		//Agarro la tarifa que viene del form
		Tarifa price = new Tarifa();
		price.setConcepto(conceptoId);
		price.setImporte(nuevaTarifa);
		price.setFechaComienzo(DateUtil.getDateToday());

		//si es igual a la ultima no la actualizo, sino la agrego a la lista
		Tarifa tarifaUltima = priceDao.getLastPriceByConcept(conceptoId);
		
		if (tarifaUltima == null || price.getImporte() != tarifaUltima.getImporte()){
			priceDao.save(price);	
		}
		
	}

	
}
