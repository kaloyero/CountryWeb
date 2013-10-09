package com.country.hibernate.dao;

import java.util.List;

import com.country.common.GenericDao;
import com.country.hibernate.model.Mascota;

public interface PetDao extends GenericDao<Mascota, Integer> {

	List<Mascota> findMascotassByUnidad(Integer unidadId);

}
