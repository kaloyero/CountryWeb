package com.country.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
	
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

	
}
