package com.country.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.form.UnidadForm;
import com.country.hibernate.dao.IntegratorDao;
import com.country.hibernate.dao.UnitDao;
import com.country.hibernate.model.Integrante;
import com.country.hibernate.model.Unidad;
import com.country.mappers.UnidadMapper;
import com.country.services.UnitManager;

@Service("unitManager")
public class UnitManagerImpl extends AbstractManagerImpl<Unidad> implements UnitManager{

	@Autowired
    private UnitDao unitDao;
	
	@Autowired
    private IntegratorDao integratorDao;

	
	protected GenericDao<Unidad, Integer> getDao() {
		return unitDao;
	}

	private Unidad findById(Integer id) {
		Unidad dto = unitDao.findById(id);
		return dto;
	}

	public UnidadForm findFormById(Integer id) {
		UnidadForm form = new UnidadForm();
		
		Unidad dto = findById(id);
		form = (UnidadForm) UnidadMapper.getForm(dto);
		
		return form;
	}
	
	public List<Integrante> getIntegrators(Integer id) {
		return integratorDao.getIntegratorsByUnit(id);
	}

	
}
