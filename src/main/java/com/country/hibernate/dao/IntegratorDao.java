package com.country.hibernate.dao;

import java.util.Collection;
import java.util.List;

import com.country.common.GenericDao;
import com.country.hibernate.model.Integrante;

public interface IntegratorDao extends GenericDao<Integrante, Integer> {

	/**
	 * Este metodo filtra por searchText. Las variables boolean sirven para indicar que campos se quiere filtrar
	 * TRAE SOLO USUARIOS ACTIVOS
	 * 
	 * @param searchText
	 * @param name
	 * @param surName
	 * @param unit
	 * @param document
	 * @return
	 */
	List<Integrante> searchComboIntegrators(String searchText,boolean name,boolean surName,boolean unit,boolean document); 
	
	/**
	 * Devuelve todos los integrantes Activos o los inactivos segun el valor del parametro 'active'
	 * 
	 * @param active
	 * @return
	 */
	List<Integrante> findAll(boolean active);
	
	
	/**
	 * Recupera los integrantes por unidad 
	 * 
	 * @param idUnit
	 * @return
	 */
	List <Integrante> getIntegratorsByUnit(int idUnit);

	/**
	 * Recupera los ids de los integrantes por unidad 
	 * 
	 * @param idUnit
	 * @return
	 */	
	Collection<Integer> getIntegratorsNumByUnit(int idUnit);

	/**
	 * Recupera los "ids persona" de los integrantes por unidad 
	 * 
	 * @param idUnit
	 * @return
	 */	
	Collection<Integer> getIntegPersonNumByUnit(int idUnit);
}
