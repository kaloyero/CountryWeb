package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
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

	@Transactional
	public void updateList(String telefonosStrList, int idPerson) {
		
		List<Telefono> listTele= telephoneDao.findAllByProperty("persona", idPerson);
		
		//Mapeo los telefonos
		List<Telefono> telefonos = new ArrayList<Telefono>();
		for (Telefono telefono : TelefonoMapper.getTelefonos(telefonosStrList)) {
			telefonos.add(telefono);
		}
		
		if (telefonos != null && telefonos.size() > 0 ){
			//INSERT UPDATE
			//Pregunto si modifico o agrego.
			for (Telefono tel : telefonos ) {
				if (tel.getId() != 0){
					telephoneDao.save(tel);
				} else {
					telephoneDao.update(tel);
				}
			}
			
			//DELETE
			//Borro los telefonos q ya no estan
			for (Telefono telefono : listTele) {
				boolean delete = true;
				for (Telefono tele : telefonos) {
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

	@Transactional
	public void saveList(String telefonosStrList, int idPerson) {
		if (telefonosStrList != null){
			for (Telefono telefono : TelefonoMapper.getTelefonos(telefonosStrList)) {
				telefono.setPersona(idPerson);
				save(telefono);
			}
		}
		
	}

}
