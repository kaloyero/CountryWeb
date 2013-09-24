package com.country.hibernate.dao;

import java.util.Date;

import com.country.common.GenericDao;
import com.country.hibernate.model.Aviso;

public interface NotificationDao extends GenericDao<Aviso, Integer> {

	public Integer getNumAvisosByPerson(int idPerson,Date dateEnd);

}
