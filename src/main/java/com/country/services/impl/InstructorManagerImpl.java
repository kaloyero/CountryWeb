package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.Constants;
import com.country.common.GenericDao;
import com.country.form.InstructorForm;
import com.country.form.TipoForm;
import com.country.hibernate.dao.InstructorDao;
import com.country.hibernate.model.Direccion;
import com.country.hibernate.model.Instructor;
import com.country.hibernate.model.Telefono;
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
	public void save(InstructorForm form) {
		Instructor dto = InstructorMapper.getInstructor(form);
		
		//Seteo que es un instructor
		dto.getPersona().setTipo(Constants.PERSONA_INSTRUCTOR);
		
		instructorDao.save(dto);
		//Inserta telefonos
		telephoneManager.saveList(form.getPersona().getTelefonos(),dto.getPersona().getId());
		//Inserta direcciones
		addressManager.saveList(form.getPersona().getDirecciones(),dto.getPersona().getId());
		
	}
	
	public Instructor findById(Integer id) {
		
		Instructor dto = instructorDao.findById(id);
		return dto;
	}

	public InstructorForm findFormById(Integer id) {
		InstructorForm form = new InstructorForm();
		
		Instructor dto = findById(id);
		List<Telefono> telefonos = telephoneManager.findListByIdPerson(dto.getPersona().getId());
		List<Direccion> direcciones = addressManager.findListByIdPerson(dto.getPersona().getId());
		
		form = (InstructorForm) InstructorMapper.getForm(dto,telefonos,direcciones);
		
		return form;
	}
	

	@Transactional
	public void update(InstructorForm form) {
		Instructor dto = InstructorMapper.getInstructor(form);
		
		instructorDao.update(dto);
		//Modifico la lista de telefonos
		telephoneManager.updateList(form.getPersona().getTelefonos(),dto.getPersona().getId());
		//Modifico la lista de direcciones
		addressManager.updateList(form.getPersona().getDirecciones(),dto.getPersona().getId());
		
	}

	public List<TipoForm> getIntegratorNames() {
		List<Instructor> listInstructors = instructorDao.findAll();
		
		List<TipoForm> list = new ArrayList<TipoForm>();
		for (Instructor instructor : listInstructors) {
			String name = instructor.getPersona().getNombre() + " " + instructor.getPersona().getApellido() + " - " + instructor.getPersona().getTipoDoc().getNombre() + " " + instructor.getPersona().getNroDoc();
			TipoForm tipo = new TipoForm();
			tipo.setId(instructor.getId());
			tipo.setNombre(name);
			list.add(tipo);
		}
				
		return list;
	}
	
}
