package com.country.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.country.session.UsuarioInfo;

public class SessionUtil {

	public static UsuarioInfo getUserInfo(HttpServletRequest request){
		HttpSession session = request.getSession(true);
		UsuarioInfo usuarioConectado = (UsuarioInfo) session.getAttribute("InfoUsuario");
		
		return usuarioConectado;
						
	}
	
	public static boolean isAdminUser(HttpServletRequest request){
		HttpSession session = request.getSession(true);
		String usuarioConectado = (String) session.getAttribute("TipoDeUsuario");
		
		if (usuarioConectado.equals("Admin")){
			return true;
		}else{
			return false;
		}
						
	}

	public static boolean isPropietarionUser(HttpServletRequest request){
		HttpSession session = request.getSession(true);
		String usuarioConectado = (String) session.getAttribute("TipoDeUsuario");
		
		if (usuarioConectado.equals("Propietario")){
			return true;
		}else{
			return false;
		}
						
	}
	
	public static boolean isEmployeePerson(String userType){
		if (Constants.PERSONA_EMPLEADO.equals(userType)){
			return true;
		}else{
			return false;
		}					
	}

	public static boolean isIntegrantePerson(String userType){
		if (Constants.PERSONA_INTEGRANTE.equals(userType)){
			return true;
		}else{
			return false;
		}
						
	}	

	
}
