package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.form.AvisoCategoriaForm;
import com.country.form.TipoForm;
import com.country.hibernate.dao.NotificationCategoryDao;
import com.country.hibernate.model.AvisoCategoria;
import com.country.hibernate.model.Tarifa;
import com.country.mappers.TipoMapper;
import com.country.services.NotificationCategoryManager;
import com.country.services.PriceManager;

@Service("notificationCategoryManager")
public class NotificationCategoryManagerImpl extends AbstractManagerImpl<AvisoCategoria> implements NotificationCategoryManager{

	@Autowired
    private NotificationCategoryDao notificationCategoryDao;
	
	@Autowired
    private PriceManager priceManager;

	
	protected GenericDao<AvisoCategoria, Integer> getDao() {
		return notificationCategoryDao;
	}

	public AvisoCategoria findById(Integer id) {
		AvisoCategoria dto = notificationCategoryDao.findById(id);
		return dto;
	}

	public AvisoCategoriaForm findFormById(int id) {
		AvisoCategoriaForm form = new AvisoCategoriaForm();
		
		AvisoCategoria dto = findById(id);
		if (dto != null){
			Tarifa tarifa = priceManager.getLastPriceByConcept(dto.getConcepto().getId());
			form = (AvisoCategoriaForm) TipoMapper.getForm(dto,tarifa); 
		}
		
		return form;
		
	}
	
	public void save(AvisoCategoriaForm form) {
		AvisoCategoria dto = TipoMapper.getAvisoCategoria(form);
		
		notificationCategoryDao.save(dto);
		priceManager.saveTarifa(dto.getConcepto().getId(), form.getConcepto().getImporte());
		
		
		
	}

	public void update(AvisoCategoriaForm form) {
		AvisoCategoria dto = TipoMapper.getAvisoCategoria(form);
		
		notificationCategoryDao.update(dto);
		priceManager.updateTarifa(dto.getConcepto().getId(), form.getConcepto().getImporte());
		
	}

	public List<TipoForm> listAllCategoriesDescription(){
		List<AvisoCategoria> lista= notificationCategoryDao.findAll();
		List<TipoForm> listaCategorias= new ArrayList<TipoForm>();
		
		for (AvisoCategoria cat : lista) {
			TipoForm tipo = new TipoForm();
			Tarifa tarifa = priceManager.getLastPriceByConcept(cat.getConcepto().getId());
			
			tipo.setId(cat.getId());
			tipo.setNombre(cat.getNombre() + " - $"+  tarifa.getImporte() +" - " + cat.getPublishDays() + " dias.");
			listaCategorias.add(tipo);
			
		}
		return listaCategorias;
		
		
	}
	
}
