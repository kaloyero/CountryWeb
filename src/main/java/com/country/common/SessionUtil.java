package com.country.common;

import javax.servlet.http.HttpServletRequest;

import com.country.session.SessionUsr;

public class SessionUtil {

	public static boolean isAdminUser(){
		if (SessionUsr.TipoAplicacion().equals(Constants.TIPO_APLICACION_ADMIN)){
			return true;
		}else{
			return false;
		}
						
	}

	public static boolean isPropietarionUser(HttpServletRequest request){
		if (SessionUsr.TipoAplicacion().equals(Constants.TIPO_APLICACION_PROPIETARIO)){
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
