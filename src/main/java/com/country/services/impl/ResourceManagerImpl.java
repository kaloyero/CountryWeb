package com.country.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.RecursoForm;
import com.country.hibernate.dao.PriceDao;
import com.country.hibernate.dao.ResourceAvaiableDao;
import com.country.hibernate.dao.ResourceDao;
import com.country.hibernate.model.Recurso;
import com.country.hibernate.model.RecursoDisponibilidad;
import com.country.hibernate.model.Tarifa;
import com.country.mappers.RecursoMapper;
import com.country.services.PriceManager;
import com.country.services.ResourceManager;

@Service("resourceManager")
public class ResourceManagerImpl extends AbstractManagerImpl<Recurso> implements ResourceManager{

	@Autowired
    private PriceManager priceManager;
	
	@Autowired
    private ResourceDao resourceDao;
	
	@Autowired
    private ResourceAvaiableDao resourceAvaiableDao;
	
	@Autowired
    private PriceDao priceDao;
	
	protected GenericDao<Recurso, Integer> getDao() {
		return resourceDao;
	}
	@Transactional
	public Recurso findById(Integer id) {
		Recurso dto = resourceDao.findById(id);
		return dto;
	}
	
	@Transactional
	public int save(Recurso dto, double tarifa) {
// 		TODO 	Agregar Asignacion
		
		int id = 0;		
		id = resourceDao.save(dto);
		
		//Guarda el importe
		Tarifa price = new Tarifa();
		price.setConcepto(dto.getConcepto().getId());
		price.setImporte(tarifa);
		price.setFechaComienzo(dto.getConcepto().getFechaComienzo());
		priceDao.save(price);		

		//Agrego la disponibilidad
		for (RecursoDisponibilidad recDispo : dto.getDisponibilidad()) {
			recDispo.setRecurso(id);
			resourceAvaiableDao.save(recDispo);
		}
		
		return id;
	}
	
	@Transactional	
	public void update(RecursoForm form) {
		
		Recurso dto = RecursoMapper.getRecurso(form);
		
		/* Actualizo los horarios disponible */
		List<RecursoDisponibilidad> listRecDispo = resourceAvaiableDao.findAllByProperty("recurso", form.getId());

		for (RecursoDisponibilidad recDispo : dto.getDisponibilidad()) {
			boolean insert = true;
			for (RecursoDisponibilidad recDispoOld : listRecDispo) {
					
				if (recDispo.getDiaSemana() == recDispoOld.getDiaSemana() && recDispo.getHoraIni() == recDispoOld.getHoraIni()){
					insert = false;
				}
			}
			if (insert){
				resourceAvaiableDao.save(recDispo);
			}			
		}
		
		//Borro los dias q ya no estan
		for (RecursoDisponibilidad recDispo : listRecDispo) {
			boolean delete = true;
			for (RecursoDisponibilidad recDispoOut : dto.getDisponibilidad()) {
				if (recDispo.getDiaSemana() == recDispoOut.getDiaSemana() && recDispo.getHoraIni() == recDispoOut.getHoraIni() ){
					delete = false;
				}
			}
			if (delete){
				resourceAvaiableDao.delete(recDispo);
			}
		}		
		
		/* Actualizo la tarifa */
		//Agarro la tarifa que viene del form
		Tarifa price = new Tarifa();
		price.setConcepto(dto.getConcepto().getId());
		price.setImporte(form.getImporte());
		price.setFechaComienzo(new Date(2012, 12, 12));
		
		//si es igual a la ultima no la actualizo, sino la agrego a la lista
		Tarifa tarifaUltima = priceDao.getLastPriceByConcept(dto.getConcepto().getId());
		
		if (tarifaUltima == null || price.getImporte() != tarifaUltima.getImporte()){
			priceDao.save(price);	
		}
		
		resourceDao.update(dto);
		
	}
	
	
	public RecursoForm getResourceForm(Integer id){
		Recurso dto = resourceDao.findById(id);
		Tarifa tarifa = priceManager.getLastPriceByConcept(dto.getConcepto().getId());
		
		RecursoForm form = (RecursoForm) RecursoMapper.getForm(dto,tarifa.getImporte());
		
		return form;
	}

}
