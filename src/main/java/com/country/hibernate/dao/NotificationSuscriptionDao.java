package com.country.hibernate.dao;

import com.country.common.GenericDao;
import com.country.hibernate.model.AvisoSuscripcion;

public interface NotificationSuscriptionDao extends GenericDao<AvisoSuscripcion, Integer> {

	AvisoSuscripcion findByCategoryUser (int categoriaId, int userId);
}
