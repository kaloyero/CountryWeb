package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.hibernate.dao.ConceptDao;
import com.country.hibernate.dao.PriceDao;
import com.country.hibernate.model.Concepto;
import com.country.hibernate.model.Tarifa;
import com.country.services.ConceptManager;
import com.country.session.ConfigurationData;

@Service("conceptManager")
public class ConceptManagerImpl extends AbstractManagerImpl<Concepto> implements ConceptManager{

	@Autowired
    private ConceptDao conceptDao;

	@Autowired
    private PriceDao priceDao;

	protected GenericDao<Concepto, Integer> getDao() {
		return conceptDao;
	}
	
	public Concepto findById(Integer id) {
		Concepto dto = conceptDao.findById(id);
		return dto;
	}
	
	@Transactional
	public void save(Concepto dto, Double tarifa) {
		
		int id = conceptDao.save(dto);
		
		//Controla que no sea el Concepto gratis para eventos
		if (id != ConfigurationData.getCONCEPTO_GRATIS_ID()){
			Tarifa price = new Tarifa();
			price.setConcepto(id);
			price.setImporte(tarifa);
			price.setFechaComienzo(dto.getFechaComienzo());
			priceDao.save(price);
		}
		
	}
	
	@Transactional
	public void update(Concepto dto,Double tarifa) {
		conceptDao.update(dto);

		//Controla que no sea el Concepto gratis para eventos
		if (dto.getId() != ConfigurationData.getCONCEPTO_GRATIS_ID()){
			//Agarro la tarifa que viene del form
			Tarifa price = new Tarifa();
			price.setConcepto(dto.getId());
			price.setImporte(tarifa);
			price.setFechaComienzo(dto.getFechaComienzo());
	
			//si es igual a la ultima no la actualizo, sino la agrego a la lista
			Tarifa tarifaUltima = priceDao.getLastPriceByConcept(dto.getId());
			if (price.getImporte() != tarifaUltima.getImporte()){
				priceDao.save(price);	
			}
		}

	}
	
}
