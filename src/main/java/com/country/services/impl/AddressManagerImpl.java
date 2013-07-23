package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.DireccionForm;
import com.country.hibernate.dao.AddressDao;
import com.country.hibernate.model.Direccion;
import com.country.mappers.DireccionMapper;
import com.country.services.AddressManager;

@Service("addressManager")
public class AddressManagerImpl extends AbstractManagerImpl<Direccion> implements AddressManager{

	@Autowired
    private AddressDao addressDao;
	
	protected GenericDao<Direccion, Integer> getDao() {
		return addressDao;
	}

	public List<Direccion> findListByIdPerson(Integer id) {
		List<Direccion> list = addressDao.findAllByProperty("person", id);
		return list;
	}

	@Transactional
	public void saveFormList(List<DireccionForm> direcciones, int idPerson) {
		
		for (DireccionForm form : direcciones) {
			Direccion dir = DireccionMapper.getDireccion(form);
			dir.setPerson(idPerson);
			addressDao.save(dir);
		}
	}

	@Transactional
	public void updateFormList(List<DireccionForm> direcciones, int idPerson) {
		
		List<Direccion> listDire= addressDao.findAllByProperty("person", idPerson);
		
		if (direcciones != null && direcciones.size() > 0 ){
			List<Direccion> listDirecciones= new ArrayList<Direccion>();
			
			//INSERT UPDATE
			//Primero convierto las direcciones con el mapper. Y pregunto si modifico o agrego.
			for (DireccionForm dire : direcciones) {
				Direccion dir = DireccionMapper.getDireccion(dire);
				//lleno la lista de direcciones
				listDirecciones.add(dir);
				
				if (dire.getId() != 0){
					addressDao.save(dir);
				} else {
					addressDao.update(dir);
				}
			}
			
			//DELETE
			//Borro las direcciones q ya no estan
			for (Direccion  direccion : listDire) {
				boolean delete = true;
				for (Direccion dire : listDirecciones) {
					if (dire.getId() == direccion.getId() ){
						delete = false;
					}
				}
				if (delete){
					addressDao.delete(direccion);
				}
			}		
			
		} else {
			//DELETE
			//la lista de direcciones viene vacia borra todo
			for (Direccion direccion : listDire) {
				addressDao.delete(direccion);	
			}
		}
		
	}

	
}
