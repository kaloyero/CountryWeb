package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.InstructorForm;
import com.country.hibernate.dao.InstructorDao;
import com.country.hibernate.model.Instructor;
import com.country.mappers.InstructorMapper;
import com.country.services.AddressManager;
import com.country.services.InstructorManager;
import com.country.services.TelephoneManager;

@Service("instructorManager")
public class InstructorManagerImpl extends AbstractManagerImpl<Instructor> implements InstructorManager{

	@Autowired
    private InstructorDao instructorDao;
	
	@Autowired
	private AddressManager addressManager;
	
	@Autowired
	private TelephoneManager telephoneManager;

	
	protected GenericDao<Instructor, Integer> getDao() {
		return instructorDao;
	}	
	
	@Transactional
	public Instructor findById(Integer id) {
		Instructor dto = instructorDao.findById(id);
		return dto;
	}

	@Transactional
	public void save(InstructorForm form) {
		Instructor dto = InstructorMapper.getInstructor(form);
		
		instructorDao.save(dto);
		if (form.getPersona().getListaDirecciones() != null){
			addressManager.saveFormList(form.getPersona().getListaDirecciones(),dto.getPersona().getId());
		}
		if (form.getPersona().getListaTelefonos() != null){
			telephoneManager.saveFormList(form.getPersona().getListaTelefonos(),dto.getPersona().getId());
		}
		
	}

	@Transactional
	public void update(InstructorForm form) {
		Instructor dto = InstructorMapper.getInstructor(form);
		
		instructorDao.update(dto);
		addressManager.updateFormList(form.getPersona().getListaDirecciones(),form.getPersona().getId());
		telephoneManager.updateFormList(form.getPersona().getListaTelefonos(),form.getPersona().getId());
		
	}

	
}
