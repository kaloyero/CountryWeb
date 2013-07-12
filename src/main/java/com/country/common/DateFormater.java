package com.country.common;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {

	public static Date convertStringToDate (String d){
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		
		Date returnDate = null;

		try {
			if (d != null){
				returnDate = sdf1.parse(d);	
			}
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("ERROR (DateFormater.java) Error en el parseo de formato ");
		}

		return returnDate;
		
	}
	
	public static String convertDateToString (Date d){
		
		Format formatter = new SimpleDateFormat("dd-MM-yyyy");
		String resultDate = null; 
		if (d != null){
			resultDate = formatter.format(d);
		}

		return resultDate;
		
	}

	public static String getStringToday (){
		Date fecha = new Date();
		String resultDate = convertDateToString(fecha);

		return resultDate;
		
	}
	
	public static Date getDateToday (){
		Date fecha = new Date();

		return fecha;
		
	}
}
