package com.country.services;

import com.country.hibernate.model.Tarifa;

public interface PriceManager extends AbstractManager<Tarifa>{

	Tarifa findById(Integer id);
	
	Tarifa getLastPriceByConcept(int idConcept);
	
	void saveTarifa(int conceptoId, Double nuevaTarifa);
	
	void updateTarifa(int conceptoId, Double nuevaTarifa);
	
}
