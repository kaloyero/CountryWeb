package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.TipoInfraccionForm;
import com.country.hibernate.dao.TypeInfractionDao;
import com.country.hibernate.model.Tarifa;
import com.country.hibernate.model.TipoInfraccion;
import com.country.mappers.TipoMapper;
import com.country.services.PriceManager;
import com.country.services.TypeInfractionManager;

@Service("typeInfractionManager")
public class TypeInfractionManagerImpl extends AbstractManagerImpl<TipoInfraccion> implements TypeInfractionManager{

	@Autowired
    private TypeInfractionDao typeInfractionDao;
	
	@Autowired
    private PriceManager priceManager;

	
	protected GenericDao<TipoInfraccion, Integer> getDao() {
		return typeInfractionDao;
	}

	@Transactional
	public TipoInfraccion findById(Integer id) {
		TipoInfraccion dto = typeInfractionDao.findById(id);
		return dto;
	}

	@Transactional
	public TipoInfraccionForm findByFormId(Integer id) {
		TipoInfraccionForm form = new TipoInfraccionForm();
		TipoInfraccion dto = findById(id);
		if (dto != null){
			Tarifa tarifa = priceManager.getLastPriceByConcept(dto.getConcepto().getId());
			form =TipoMapper.getForm(dto,tarifa); 
		}
		
		return form;
	}

	@Transactional
	public void save(TipoInfraccionForm form) {
		TipoInfraccion dto = TipoMapper.getTipoInfraccion(form);
		
		typeInfractionDao.save(dto);
		priceManager.saveTarifa(dto.getConcepto().getId(), form.getConcepto().getImporte());
		
		
		
	}

	@Transactional
	public void update(TipoInfraccionForm form) {
		TipoInfraccion dto = TipoMapper.getTipoInfraccion(form);
		
		typeInfractionDao.update(dto);
		priceManager.updateTarifa(dto.getConcepto().getId(), form.getConcepto().getImporte());
		
	}

}
