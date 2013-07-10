package com.country.services;

import com.country.hibernate.model.Periodo;

public interface PeriodManager extends AbstractManager<Periodo>{

	Periodo findById(Integer id);
	
}
