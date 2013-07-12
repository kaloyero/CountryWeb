package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.IntegranteForm;
import com.country.form.TipoForm;
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

	public List<TipoForm> getIntegratorNames() {
		List<Integrante> listIntegrators = integratorDao.findAll();
		
		List<TipoForm> list = new ArrayList<TipoForm>();
		for (Integrante integrator : listIntegrators) {
			String name = integrator.getPersona().getNombre() + " " + integrator.getPersona().getApellido() + " - " + integrator.getPersona().getTipoDoc().getNombre() + " " + integrator.getPersona().getNroDoc();
			TipoForm tipo = new TipoForm();
			tipo.setId(integrator.getId());
			tipo.setNombre(name);
			list.add(tipo);
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