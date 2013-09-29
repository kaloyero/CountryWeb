package com.country.session;



public class ConfigurationData {

	private static int USUARIO_DEFAULT_RECLAMOS=2;
	
	private static int CONCEPTO_GRATIS_ID=1;
	
	public static int getCONCEPTO_GRATIS_ID() {
		return CONCEPTO_GRATIS_ID;
	}

	public static void setCONCEPTO_GRATIS_ID(int cONCEPTO_GRATIS_ID) {
		CONCEPTO_GRATIS_ID = cONCEPTO_GRATIS_ID;
	}

	public static int getUSUARIO_DEFAULT_RECLAMOS() {
		return USUARIO_DEFAULT_RECLAMOS;
	}

	public static void setUSUARIO_DEFAULT_RECLAMOS(int uSUARIO_DEFAULT_RECLAMOS) {
		USUARIO_DEFAULT_RECLAMOS = uSUARIO_DEFAULT_RECLAMOS;
	}
	
	
}
