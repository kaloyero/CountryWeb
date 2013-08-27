package com.country.services;

import com.country.hibernate.model.Usuario;

public interface UserManager extends AbstractManager<Usuario>{
	
	Usuario findById(Integer id);
	
	void save (Usuario dto);
	
}
