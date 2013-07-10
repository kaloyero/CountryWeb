package com.country.services;

import com.country.hibernate.model.LiquidacionCargo;

public interface LiquidationChargeManager extends AbstractManager<LiquidacionCargo>{

	LiquidacionCargo findById(Integer id);

}
