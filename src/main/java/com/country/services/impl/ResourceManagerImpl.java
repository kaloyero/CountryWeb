package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.hibernate.dao.ResourceDao;
import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Asignacion;
import com.country.hibernate.model.Recurso;
import com.country.hibernate.model.Tarifa;
import com.country.services.ResourceManager;

@Service("resourceManager")
public class ResourceManagerImpl extends AbstractManagerImpl<Recurso> implements ResourceManager{

	@Autowired
    private ResourceDao resourceDao;
	
	protected GenericDao<Recurso, Integer> getDao() {
		return resourceDao;
	}
	@Transactional
	public Recurso findById(Integer id) {
		Recurso dto = resourceDao.findById(id);
		dto.getDisponibilidad().size();
		return dto;
	}
	
	@Transactional
	public int save(Recurso dto,Recurso dtoTest) {
// 		TODO 	Agregar Asignacion
		
		int id = 0;		
		id = resourceDao.save(dto);
		

		return id;
	}

}
