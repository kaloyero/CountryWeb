package com.country.services;

import java.util.List;

import com.country.hibernate.model.Mascota;

public interface PetManager extends AbstractManager<Mascota>{

	Mascota findById(Integer id);
	List findByMascotasByUnidad(Integer unidadId);
}
