package com.country.hibernate.dao;

import java.util.List;

import com.country.common.GenericDao;
import com.country.hibernate.model.Instructor;

public interface InstructorDao extends GenericDao<Instructor, Integer> {

	/**
	 * Devuelve todos los instructores Activos o los inactivos segun el valor del parametro 'active'
	 * 
	 * @param active
	 * @return
	 */
	List<Instructor> findAll(boolean active);
}
