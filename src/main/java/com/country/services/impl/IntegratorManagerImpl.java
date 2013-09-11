package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.Constants;
import com.country.common.GenericDao;
import com.country.form.IntegranteForm;
import com.country.form.TipoForm;
import com.country.hibernate.dao.IntegratorDao;
import com.country.hibernate.model.Integrante;
import com.country.hibernate.model.Telefono;
import com.country.mappers.IntegranteMapper;
import com.country.services.IntegratorManager;
import com.country.services.TelephoneManager;
import com.country.services.UserManager;

@Service("integratorManager")
public class IntegratorManagerImpl extends AbstractManagerImpl<Integrante> implements IntegratorManager{

	@Autowired
    private IntegratorDao integratorDao;
	
	@Autowired
	private TelephoneManager telephoneManager;
	
	@Autowired
	private UserManager userManager;

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

	
	public List<TipoForm> getIntegratorNamesPersonIdKey() {
		//usuarios activos
		List<Integrante> listIntegrators = integratorDao.findAll(true);
		
		List<TipoForm> list = new ArrayList<TipoForm>();
		for (Integrante integrator : listIntegrators) {
			String name = integrator.getPersona().getNombre() + " " + integrator.getPersona().getApellido() + " - " + integrator.getPersona().getTipoDoc().getNombre() + " " + integrator.getPersona().getNroDoc();
			TipoForm tipo = new TipoForm();
			tipo.setId(integrator.getPersona().getId());
			tipo.setNombre(name);
			list.add(tipo);
		}
				
		return list;
	}

	public List<TipoForm> getIntegratorNames() {
		//usuarios activos
		List<Integrante> listIntegrators = integratorDao.findAll(true);
		
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

		//Seteo que es un integrante
		dto.getPersona().setTipo(Constants.PERSONA_INTEGRANTE);
		
		//Creo el usuario para este integrante
		userManager.save(dto.getUsuario());
		
		integratorDao.save(dto);
		//Inserta telefonos
		telephoneManager.saveList(form.getPersona().getTelefonos(),dto.getPersona().getId());
		
	}

	@Transactional
	public void update(IntegranteForm form) {
		Integrante dto = IntegranteMapper.getIntegrante(form);
		
		//Modifico el usuario para este integrante
		userManager.update(dto.getUsuario());

		integratorDao.update(dto);
		
		//Modifico la lista de telefonos
		telephoneManager.updateList(form.getPersona().getTelefonos(),dto.getPersona().getId());
		
	}

	@Transactional
	public List<Integrante> searchComboIntegrators(String search,boolean name,boolean surName,boolean unit,boolean document) {
		List<Integrante> lista = new ArrayList<Integrante>();
		lista = integratorDao.searchComboIntegrators(search, name, surName, unit, document);
	
		return lista;
	}


	@Transactional
	public List<Integrante> listAll(boolean active) {
		List<Integrante> lista = new ArrayList<Integrante>();
		lista = integratorDao.findAll(active);
	
		return lista;
	}

	public int getPersonId(int integranteId) {
		Integrante i = integratorDao.findById(integranteId);
		return i.getPersona().getId();
	}
	
	public Integrante getIntegratorByIdUser(int userId) {
		Integrante i = integratorDao.findEntityByProperty("usuario.id",userId);
		return i;
	}
	
	@Transactional
	public List<IntegranteForm> listAllFormsComplete() {
		List<IntegranteForm> list = new ArrayList<IntegranteForm>();
		List<Integrante> integrantes = listAll();

		for (Integrante integrante : integrantes) {
			List<Telefono> telefonos = telephoneManager.findListByIdPerson(integrante.getPersona().getId());
			IntegranteForm form = (IntegranteForm) IntegranteMapper.getForm(integrante,telefonos);
			list.add(form);
		}
		
		return list;
	}
	
	@Transactional
	public List<IntegranteForm> listAllFormsComplete(boolean active) {
		List<IntegranteForm> list = new ArrayList<IntegranteForm>();
		List<Integrante> integrantes = integratorDao.findAll(active);

		for (Integrante integrante : integrantes) {
			List<Telefono> telefonos = telephoneManager.findListByIdPerson(integrante.getPersona().getId());
			IntegranteForm form = (IntegranteForm) IntegranteMapper.getForm(integrante,telefonos);
			list.add(form);
		}
		
		return list;
	}		
}