package com.country.mappers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.country.common.DateFormater;
import com.country.form.EventoForm;
import com.country.form.IntegranteForm;
import com.country.form.RecursoForm;
import com.country.form.ReservaForm;
import com.country.hibernate.model.Evento;
import com.country.hibernate.model.Recurso;
import com.country.hibernate.model.Reserva;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class ReserveMapper {

	public static Reserva getReserva(ReservaForm form) throws ParseException {

		Reserva reserva = new Reserva();

		reserva.setHoraIni(form.getHoraIni());
		reserva.setIntegrante(1);
		reserva.setFecha(DateFormater.convertStringToDate(form.getFecha()));
		 String dateString = "2001-12-25"; 
	     
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		    Date convertedDate;
			try {
				convertedDate = dateFormat.parse(dateString);
			    System.out.println("Converted string to date : " + convertedDate); 
			    System.out.println("Converted string to date : " + convertedDate); 

			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		System.out.println("Day of the week: " + reserva.getFecha().getDay());
		System.out.println("Tota " + reserva.getFecha());
		Recurso recurso = new Recurso();
		recurso.setId(form.getRecursoId());
		reserva.setRecurso(recurso);
		reserva.setDuracion(form.getDuracion());

		return reserva;

	}
	

	
}
