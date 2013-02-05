package com.country.services;

import com.country.hibernate.model.Mascota;

public interface PetManager extends AbstractManager<Mascota>{

	Mascota findById(Integer id);
	
}
