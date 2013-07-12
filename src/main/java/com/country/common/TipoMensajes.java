package com.country.common;

public class TipoMensajes {

	//Esta variable representa el tipo de mensaje RECLAMO. 
	public static final String TYPE_MESSAGE_RECLAMO =  "R";
	
	
	//Estado inicial de un Mensaje: A : ABIERTO 
	public static final String STATUS_INIT =  "A";

	//Cuando a un mensaje no se le puede asignar estado devuelve E : ERROR 
	public static final String STATUS_ERROR =  "E";

	//Cuando a un mensaje no se le puede asignar estado devuelve C : CERRADO 
	public static final String STATUS_CLOSE =  "C";
	
}
