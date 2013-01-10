package com.country.services;

import com.country.hibernate.model.Emprendimiento;

public interface BusinessManager extends AbstractManager<Emprendimiento>{

	Emprendimiento findById(Integer id);
	
}
