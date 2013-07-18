package com.country.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	static SimpleDateFormat formatterHour = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	
	/**
	 * Recibe un String y devuelve un date  formateado
	 * 
	 * @param d
	 * @return
	 */
	public static Date convertStringToDate (String d){
		
		Date returnDate = null;

		try {
			if (d != null){
				returnDate = formatter.parse(d);	
			}
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("ERROR (DateFormater.java) Error en el parseo de formato ");
		}

		return returnDate;
		
	}
	
	
	/**
	 * Recibe un date y devuelve un String formateado
	 * 
	 * @param d
	 * @return
	 */
	public static String convertDateToString (Date d){
		
		String resultDate = null; 
		if (d != null){
			resultDate = formatter.format(d);
		}

		return resultDate;
		
	}

	/**
	 * Devuelve en formato String la fecha actual
	 * 
	 * @return
	 */
	public static String getStringToday (){
		Date fecha = new Date();
		String resultDate = convertDateToString(fecha);

		return resultDate;
		
	}
	
	
	/**
	 * Toma la fecha actual
	 * 
	 * @return
	 */
	public static Date getDateToday (){
		Date fecha = new Date();
		return fecha;
	}
	
    /**
     * Suma X horas a una fecha especifica
     * 
     * @param fch
     * @param horas
     * @return
     */
    public static Date sumarHoras(Date fch, int horas) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.HOUR, horas);

        return new Date(cal.getTimeInMillis());
    }
	
    /**
     * Devuelve el dia de la semana
     * 
     * @param fch
     * @return
     */
    public static int getDiaDeLaSemana(Date fch) {
    	GregorianCalendar cal = new GregorianCalendar();
    	cal.setTime(fch);
    	return cal.get(Calendar.DAY_OF_WEEK);
    }
    
    public static int getHora(Date fch) {
    	DateFormat hourFormat = new SimpleDateFormat("HH");
    	return Integer.parseInt(hourFormat.format(fch));
    	
    	
    }    
}
