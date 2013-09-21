package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.Constants;
import com.country.common.DateUtil;
import com.country.common.GenericDao;
import com.country.common.MapperUtil;
import com.country.common.SessionUtil;
import com.country.form.LoginForm;
import com.country.hibernate.dao.UserDao;
import com.country.hibernate.model.Empleado;
import com.country.hibernate.model.Integrante;
import com.country.hibernate.model.Usuario;
import com.country.services.EmployeeManager;
import com.country.services.IntegratorManager;
import com.country.services.UserManager;
import com.country.session.UsuarioInfo;

@Service("UserManager")
public class UserManagerImpl extends AbstractManagerImpl<Usuario> implements UserManager{

	@Autowired
    private UserDao userDao;

	@Autowired
    private EmployeeManager employeeManager;

	@Autowired
    private IntegratorManager integratorManager;

	
	protected GenericDao<Usuario, Integer> getDao() {
		return userDao;
	}
	
	public Usuario findById(Integer id) {
		Usuario dto = userDao.findById(id);
		return dto;
	}
	
	@Transactional
	public void save (Usuario dto){
		//Setea que es el primer acceso
		dto.setResetPass(Constants.TRUE);
		dto.setFechaDesde(DateUtil.getDateToday());
		userDao.save(dto);
	}
	
	@Transactional
	public UsuarioInfo checkAvaiableUser (LoginForm form){
		UsuarioInfo usuarioInfo = new UsuarioInfo();
		Usuario usuario = userDao.checkUser(form.getUserName(), form.getPassword());
		
		
		if (usuario == null ){
			usuarioInfo.setErrorDescripcion("Usuario o contraseña Incorrecta");
		} else if ( ! MapperUtil.getStatusForm(usuario.getEstado())){
			//Si el usuario no esta activo lanza error
			usuarioInfo.setErrorDescripcion("El usuario se encuentra inactivo, por favor pongase en contacto con el administrador");
		} else {
			usuarioInfo.setUsuarioId(usuario.getId());
			usuarioInfo.setTipoUsuario(usuario.getTipo());
			usuarioInfo.setErrorDescripcion("");
			usuarioInfo.setNombreUsuario(usuario.getNombreUsuario());
			
			if (SessionUtil.isEmployeePerson( usuario.getTipo())){
				Empleado emp = employeeManager.getEmployeeByIdUser(usuario.getId());
				usuarioInfo.setEmpleadoId(emp.getId());
				usuarioInfo.setPersonaId(emp.getPersona().getId());
			} else {
				Integrante intg = integratorManager.getIntegratorByIdUser(usuario.getId());
				usuarioInfo.setIntegranteId(intg.getId());
				usuarioInfo.setPersonaId(intg.getPersona().getId());
			}
		}
		
		
		return usuarioInfo;
		
	}
	
	
}
