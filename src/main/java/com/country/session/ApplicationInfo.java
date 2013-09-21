package com.country.session;

import java.io.Serializable;

public class ApplicationInfo implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	private String tipoAplicacion;

	public String getTipoAplicacion() {
		return tipoAplicacion;
	}

	public void setTipoAplicacion(String tipoAplicacion) {
		this.tipoAplicacion = tipoAplicacion;
	}
	
}
