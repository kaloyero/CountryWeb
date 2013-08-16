package com.country.session;

import com.country.common.Constants;


public class SessionData {

	private static int usuarioId=2;
	private static int personaId=2;
	private static String tipoUsuario=Constants.PERSONA_EMPLEADO;
	
	
	public static String getTipoUsuario() {
		return tipoUsuario;
	}
	public static void setTipoUsuario(String tipoUsuario) {
		SessionData.tipoUsuario = tipoUsuario;
	}
	public static int getUsuarioId() {
		return usuarioId;
	}
	public static void setUsuarioId(int usuarioId) {
		SessionData.usuarioId = usuarioId;
	}
	public static int getPersonaId() {
		return personaId;
	}
	public static void setPersonaId(int personaId) {
		SessionData.personaId = personaId;
	}
	
	
	
}
