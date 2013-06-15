package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.form.TelefonoForm;
import com.country.hibernate.dao.TelephoneDao;
import com.country.hibernate.model.Telefono;
import com.country.mappers.TelefonoMapper;
import com.country.services.TelephoneManager;

@Service("telephoneManager")
public class TelephoneManagerImpl extends AbstractManagerImpl<Telefono> implements TelephoneManager{

	@Autowired
    private TelephoneDao telephoneDao;
	
	protected GenericDao<Telefono, Integer> getDao() {
		return telephoneDao;
	}

	public List<Telefono> findListByIdPerson(Integer id) {
		
		List<Telefono> list = telephoneDao.findAllByProperty("persona", id);
		return list;
	}
	
	public void saveFormList(List<TelefonoForm> telefonos, int idPerson) {
		
		for (TelefonoForm form : telefonos) {
			Telefono tel = TelefonoMapper.getTelefono(form);
			tel.setPersona(idPerson);
			telephoneDao.save(tel);
		}
	}

	public void updateFormList(List<TelefonoForm> telefonos, int idPerson) {
		
		List<Telefono> listTele= telephoneDao.findAllByProperty("persona", idPerson);
		
		if (telefonos != null && telefonos.size() > 0 ){
			List<Telefono> listTelefonos= new ArrayList<Telefono>();
			
			//INSERT UPDATE
			//Primero convierto los telefonos con el mapper. Y pregunto si modifico o agrego.
			for (TelefonoForm tele : telefonos ) {
				Telefono tel = TelefonoMapper.getTelefono(tele);
				//lleno la lista de telefonos
				listTelefonos.add(tel);
				
				if (tele.getId() != 0){
					telephoneDao.save(tel);
				} else {
					telephoneDao.update(tel);
				}
			}
			
			//DELETE
			//Borro los telefonos q ya no estan
			for (Telefono telefono : listTele) {
				boolean delete = true;
				for (Telefono tele : listTelefonos) {
					if (tele.getId() == telefono.getId() ){
						delete = false;
					}
				}
				if (delete){
					telephoneDao.delete(telefono);
				}
			}		
			
		} else {
			//DELETE
			//la lista de direcciones viene vacia borra todo
			for (Telefono telefono : listTele) {
				telephoneDao.delete(telefono);	
			}
		}
		
	}


}
