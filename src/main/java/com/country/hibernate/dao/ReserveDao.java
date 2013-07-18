package com.country.hibernate.dao;

import java.util.Date;

import com.country.common.GenericDao;
import com.country.hibernate.model.Reserva;

public interface ReserveDao extends GenericDao<Reserva, Integer> {
	
	/**
	 * Este metodo hace la busqueda de la reserva anterior o posterior segun se le indique
	 * 
	 * @param AfterBefore Si es true -> hace AFTER(">=") Si es false  -> hace BEFORE ("<")
	 * @param resource
	 * @param fecha
	 * @param horaIni
	 * @return
	 */
	public Reserva findResourceAfterBefore(boolean AfterBefore,Integer resource, Date fecha, int horaIni);
	
}
