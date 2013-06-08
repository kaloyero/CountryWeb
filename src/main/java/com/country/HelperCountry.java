package com.country;

import java.util.HashMap;
import java.util.Map;

public class  HelperCountry {
	
	private static  Map<Integer, String> dias = new HashMap<Integer,String>();
	
	
	
	public HelperCountry() {
		super();
		getDias().put(0, "Domingo");
		getDias().put(1, "Lunes");
		getDias().put(2, "Martes");
		getDias().put(3, "Miercoles");
		getDias().put(4, "Jueves");
		getDias().put(5, "Viernes");
		getDias().put(6, "Sabado");
		// TODO Auto-generated constructor stub
	}
	
	public static String getDiaSemana(int diaSemana) {
		//return getDias().get(diaSemana);
		
		switch (diaSemana) {
        	case 0:  return "Domingo";
		    case 1:  return "Lunes";
        	case 2:  return "Martes";
        	case 3:  return "Miercoles";
        	case 4:  return "Jueves";
        	case 5:  return "Viernes";
        	case 6:  return "Sabado";
		}
		return "Error";

	}
	
	
	public static  Map<Integer, String> getDias() {
		return dias;
	}

}
