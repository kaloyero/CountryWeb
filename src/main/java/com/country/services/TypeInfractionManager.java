package com.country.services;

import com.country.form.TipoInfraccionForm;
import com.country.hibernate.model.TipoInfraccion;

public interface TypeInfractionManager extends AbstractManager<TipoInfraccion>{

	TipoInfraccionForm findByFormId(Integer id);
	
	void save (TipoInfraccionForm form);
	
	void update (TipoInfraccionForm form);

}
