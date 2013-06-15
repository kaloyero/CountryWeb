package com.country.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.IntegranteForm;
import com.country.hibernate.dao.IntegratorDao;
import com.country.hibernate.model.Integrante;
import com.country.hibernate.model.Telefono;
import com.country.mappers.IntegranteMapper;
import com.country.services.IntegratorManager;
import com.country.services.TelephoneManager;

@Service("integratorManager")
public class IntegratorManagerImpl extends AbstractManagerImpl<Integrante> implements IntegratorManager{

	@Autowired
    private IntegratorDao integratorDao;
	
	@Autowired
	private TelephoneManager telephoneManager;

	protected GenericDao<Integrante, Integer> getDao() {
		return integratorDao;
	}

	@Transactional
	public IntegranteForm findFormById(Integer id) {
		IntegranteForm form = new IntegranteForm();
		
		Integrante dto = integratorDao.findById(id);
		List<Telefono> telefonos = telephoneManager.findListByIdPerson(dto.getPersona().getId());
		
		form = (IntegranteForm) IntegranteMapper.getForm(dto,telefonos);
		
		return form;
	}

	public Map<Integer, String> getIntegratorNames() {
		List<Integrante> listIntegrators = integratorDao.findAll();
		
		Map<Integer, String> list = new HashMap<Integer, String>();
		for (Integrante integrator : listIntegrators) {
			String name = integrator.getPersona().getNombre() + " " + integrator.getPersona().getApellido() + " - " + integrator.getPersona().getTipoDoc().getNombre() + " " + integrator.getPersona().getNroDoc();
			list.put(integrator.getId(),name);
		}
				
		return list;
	}

	
	@Transactional
	public void save(IntegranteForm form) {
		Integrante dto = IntegranteMapper.getIntegrante(form);
		
		integratorDao.save(dto);
		if (form.getPersona().getListaTelefonos() != null){
			telephoneManager.saveFormList(form.getPersona().getListaTelefonos(),dto.getPersona().getId());
		}
		
	}

	@Transactional
	public void update(IntegranteForm form) {
		Integrante dto = IntegranteMapper.getIntegrante(form);
		
		integratorDao.update(dto);
		telephoneManager.updateFormList(form.getPersona().getListaTelefonos(),form.getPersona().getId());
		
	}

}