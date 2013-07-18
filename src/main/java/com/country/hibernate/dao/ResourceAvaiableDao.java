package com.country.hibernate.dao;

import java.util.List;

import com.country.common.GenericDao;
import com.country.hibernate.model.RecursoDisponibilidad;

public interface ResourceAvaiableDao extends GenericDao<RecursoDisponibilidad, Integer> {
	
	List<RecursoDisponibilidad> listDisponibilidadRecursoPorDia(int recurso,int dia);

}
