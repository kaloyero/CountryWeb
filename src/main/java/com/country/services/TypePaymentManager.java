package com.country.services;

import com.country.hibernate.model.TipoPagos;

public interface TypePaymentManager extends AbstractManager<TipoPagos>{

	TipoPagos findById(Integer id);
}
