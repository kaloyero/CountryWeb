package com.country.session;

public class SessionUsr {
	   
	   protected SessionUsr() {}
 
	     private final static UsuarioInfo usuarioInfo = new UsuarioInfo();
	     private final static ApplicationInfo appInfo = new ApplicationInfo();

	 
	   public static UsuarioInfo User() {
	     return usuarioInfo;
	   }
	   
	   public static String TipoAplicacion() {
		     return appInfo.getTipoAplicacion();
	   }

	   public static ApplicationInfo Aplicacion() {
		     return appInfo;
	   }
	   
	   public static void setUser(UsuarioInfo usr) {
		   	usuarioInfo.setEmpleadoId(usr.getEmpleadoId());
		   	usuarioInfo.setErrorDescripcion(usr.getErrorDescripcion());
		   	usuarioInfo.setIntegranteId(usr.getIntegranteId());
		   	usuarioInfo.setNombreUsuario(usr.getNombreUsuario());
		   	usuarioInfo.setPersonaId(usr.getPersonaId());
		   	usuarioInfo.setTipoUsuario(usr.getTipoUsuario());
		   	usuarioInfo.setUsuarioId(usr.getUsuarioId());
		   	usuarioInfo.setUnidad(usr.getUnidad());
	   }

	}