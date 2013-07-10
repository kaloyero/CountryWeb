package com.country.services;

import com.country.hibernate.model.Liquidacion;

public interface LiquidationManager extends AbstractManager<Liquidacion>{

	Liquidacion findById(Integer id);

}
