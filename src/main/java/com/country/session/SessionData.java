package com.country.session;

import com.country.common.Constants;


public class SessionData {

	private static int usuarioId=2;
	private static int personaId=5;
	private static int integranteId=2;
	private static int empleadoId=2;
	private static String tipoUsuario=Constants.PERSONA_INTEGRANTE;
	
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
	public static int getIntegranteId() {
		return integranteId;
	}
	public static void setIntegranteId(int integranteId) {
		SessionData.integranteId = integranteId;
	}
	public static int getEmpleadoId() {
		return empleadoId;
	}
	public static void setEmpleadoId(int empleadoId) {
		SessionData.empleadoId = empleadoId;
	}
	
	
	
}
