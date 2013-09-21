package com.country.hibernate.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.UserDao;
import com.country.hibernate.model.Usuario;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UserDao{

	@Override
	protected Class<Usuario> getEntityClass() {
		return Usuario.class;
	}

    public void update(Usuario obj) {
      	getSession().update(obj);
    }
    
    @Transactional
    public Usuario checkUser(String user, String password) {
        DetachedCriteria criteria = createDetachedCriteria();
        criteria.add(Restrictions.eq("nombreUsuario", user));
        criteria.add(Restrictions.eq("clave", password));
        return (Usuario) criteria.getExecutableCriteria(getSession()).uniqueResult();
    }

}
