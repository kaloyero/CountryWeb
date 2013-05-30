package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.IntegranteActividadForm;
import com.country.form.IntegranteForm;
import com.country.hibernate.dao.IntegratorActivityDao;
import com.country.hibernate.model.IntegranteActividades;
import com.country.mappers.IntegranteActividadMapper;
import com.country.services.IntegratorActivityManager;

@Service("integratorActivityManager")
public class IntegratorActivityManagerImpl extends AbstractManagerImpl<IntegranteActividades> implements IntegratorActivityManager{

	@Autowired
    private IntegratorActivityDao integratorActivityDao;
	

	protected GenericDao<IntegranteActividades, Integer> getDao() {
		return integratorActivityDao;
	}

	@Transactional
	public IntegranteActividadForm findById(Integer id) {
		IntegranteActividadForm form = new IntegranteActividadForm();
		
		//TODO hacer este metodo		
		return form;
	}

	@Transactional
	public void save(IntegranteActividadForm form) {
		IntegranteActividades dto = IntegranteActividadMapper.getIntegranteActividad(form);
		
		integratorActivityDao.save(dto);

	}

	@Transactional
	public void update(IntegranteForm form) {
		//TODO hacer este metodo		
	}
	
	

}