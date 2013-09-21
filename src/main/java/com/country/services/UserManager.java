package com.country.services;

import com.country.form.LoginForm;
import com.country.hibernate.model.Usuario;
import com.country.session.UsuarioInfo;

public interface UserManager extends AbstractManager<Usuario>{
	
	Usuario findById(Integer id);
	
	void save (Usuario dto);
	
	UsuarioInfo checkAvaiableUser (LoginForm form);
	
}
