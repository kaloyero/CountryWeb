package com.country.services;

import com.country.hibernate.model.Usuario;

public interface UserManager extends AbstractManager<Usuario>{
	
	public void save (Usuario dto);
	
}
