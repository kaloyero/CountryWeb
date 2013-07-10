package com.country.services;

import com.country.hibernate.model.Pago;

public interface PaymentManager extends AbstractManager<Pago>{

	Pago findById(Integer id);
	
}
