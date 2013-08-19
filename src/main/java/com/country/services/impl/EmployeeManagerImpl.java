package com.country.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.Constants;
import com.country.common.GenericDao;
import com.country.form.EmpleadoForm;
import com.country.hibernate.dao.EmployeeDao;
import com.country.hibernate.model.Direccion;
import com.country.hibernate.model.Empleado;
import com.country.hibernate.model.Telefono;
import com.country.mappers.EmpleadoMapper;
import com.country.services.AddressManager;
import com.country.services.EmployeeManager;
import com.country.services.TelephoneManager;
import com.country.services.UserManager;

@Service("employeeManager")
public class EmployeeManagerImpl extends AbstractManagerImpl<Empleado> implements EmployeeManager{

	@Autowired
    private EmployeeDao employeeDao;
	
	@Autowired
	private TelephoneManager telephoneManager;
	
	@Autowired
	private AddressManager addressManager;
	
	@Autowired
	private UserManager userManager;

	protected GenericDao<Empleado, Integer> getDao() {
		return employeeDao;
	}
	
	public Empleado findById(Integer id) {
		Empleado dto = employeeDao.findById(id);
		return dto;
	}
	
	@Transactional
	public EmpleadoForm findFormById(Integer id) {
		EmpleadoForm form = new EmpleadoForm();
		
		Empleado emp = employeeDao.findById(id);
		List<Telefono> telefonos = telephoneManager.findListByIdPerson(emp.getPersona().getId());
		List<Direccion> direcciones = addressManager.findListByIdPerson(emp.getPersona().getId());
		
		form = (EmpleadoForm) EmpleadoMapper.getForm(emp, telefonos,direcciones);
		
		return form;
	}
	
	@Transactional
	public void save(EmpleadoForm form) {
		Empleado dto = EmpleadoMapper.getEmpleado(form);

		//Seteo que es un empleado
		dto.getPersona().setTipo(Constants.PERSONA_EMPLEADO);
		
		employeeDao.save(dto);
		//Creo el usuario para este empleado
		userManager.save(dto.getUsuario());

		//Inserta telefonos
		telephoneManager.saveList(form.getPersona().getTelefonos(),dto.getPersona().getId());
		//Inserta direcciones
		addressManager.saveList(form.getPersona().getDirecciones(),dto.getPersona().getId());
		
	}

	@Transactional
	public void update(EmpleadoForm form) {
		Empleado dto = EmpleadoMapper.getEmpleado(form);
		
		employeeDao.update(dto);
		//Modifico el usuario para este empleado
		userManager.save(dto.getUsuario());

		//Modifico la lista de telefonos
		telephoneManager.updateList(form.getPersona().getTelefonos(),dto.getPersona().getId());
		//Modifico la lista de direcciones
		addressManager.updateList(form.getPersona().getDirecciones(),dto.getPersona().getId());	
	}
	
	public Empleado findEmployeeByIdPerson(int idPerson) {
		Empleado dto = employeeDao.findEmployeeByIdPerson(idPerson);
		return dto;
		
	}

}
