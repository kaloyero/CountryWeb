package com.country.services;

import java.util.List;

import com.country.form.IntegranteForm;
import com.country.form.TipoForm;
import com.country.hibernate.model.Integrante;

public interface IntegratorManager extends AbstractManager<Integrante>{
	
	IntegranteForm findFormById(Integer id);
	
	void save(IntegranteForm form);
	
	void update(IntegranteForm form);
	
	List<TipoForm> getIntegratorNames();
	
	List<TipoForm> getIntegratorNamesPersonIdKey();
	
	/**
	 * Devuelve todos los integrantes Activos o los inactivos segun el valor del parametro 'active'
	 * 
	 * @param active
	 * @return
	 */
	List<Integrante> listAll(boolean active);

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
	List<Integrante> searchComboIntegrators(String search,boolean name,boolean surName,boolean unit,boolean document);
	
	int getPersonId(int integranteId);
	
	/**
	 * Este metodo devuelve el integrante filtrando por el userId
	 * 
	 * @param userId
	 * @return
	 */
	public Integrante getIntegratorByIdUser(int userId);
	
	public List<IntegranteForm> listAllFormsComplete();

	public List<IntegranteForm> listAllFormsComplete(boolean active);	
	
}
