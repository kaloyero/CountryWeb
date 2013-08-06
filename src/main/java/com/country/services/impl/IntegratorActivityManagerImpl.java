package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.ActividadForm;
import com.country.form.IntegranteActividadForm;
import com.country.form.IntegranteForm;
import com.country.hibernate.dao.IntegratorActivityDao;
import com.country.hibernate.model.IntegranteActividades;
import com.country.mappers.IntegranteActividadMapper;
import com.country.services.ActivityManager;
import com.country.services.IntegratorActivityManager;
import com.country.services.IntegratorManager;

@Service("integratorActivityManager")
public class IntegratorActivityManagerImpl extends AbstractManagerImpl<IntegranteActividades> implements IntegratorActivityManager{

	@Autowired
    private IntegratorActivityDao integratorActivityDao;
	
	@Autowired
    private IntegratorManager integratorManager ;
	
	@Autowired
    private ActivityManager activityManager ;

	
	protected GenericDao<IntegranteActividades, Integer> getDao() {
		return integratorActivityDao;
	}

	@Transactional
	private IntegranteActividades findById(Integer id) {
		IntegranteActividades dto = integratorActivityDao.findById(id);
		return dto;
	}

	@Transactional
	public IntegranteActividadForm findFormById(Integer id) {
		IntegranteActividadForm form = new IntegranteActividadForm();
		
		IntegranteActividades dto = findById(id);
//		IntegranteForm intForm = integratorManager.findFormById(id);
//		ActividadForm actForm = activityManager.findFormById(id);
//				
//		form = (IntegranteActividadForm) IntegranteActividadMapper.getForm(dto,intForm , actForm );
		form = (IntegranteActividadForm) IntegranteActividadMapper.getForm(dto);
		
		return form;
	}

	
	@Transactional
	public void update(IntegranteActividadForm form) {
		IntegranteActividades dto = IntegranteActividadMapper.getIntegranteActividad(form);
		
		integratorActivityDao.save(dto);
	}
	
	/**
	 * Este metodo devuelve todos los Integrantes(FORM) por actividad especifica 
	 * 
	 * @param id de recurso
	 * @return lista de Integrantes
	 */
	public List<IntegranteForm> findAllIntegrantorFormByActivityId(Integer id) {
		List<IntegranteForm> list = new ArrayList<IntegranteForm>();
		List<IntegranteActividades> searchList = new ArrayList<IntegranteActividades>();
		searchList = integratorActivityDao.findAllByProperty("actividad", id);
		for (IntegranteActividades dto : searchList) {
			IntegranteForm integrante = integratorManager.findFormById(dto.getIntegrante());
			list.add(integrante);
			
		}
		
		return list;
	}
	
	/**
	 * Este metodo devuelve todas las Actividades (FORM) por un integrante especifico 
	 * 
	 * @param id de Integrante
	 * @return lista de Actividades
	 */
	public List<ActividadForm> findAllActivitiesByIntegratorId(Integer id) {
		List<ActividadForm> list = new ArrayList<ActividadForm>();
		List<IntegranteActividades> searchList = new ArrayList<IntegranteActividades>();
		searchList = integratorActivityDao.findAllByProperty("integrante", id);
		for (IntegranteActividades dto : searchList) {
			ActividadForm actividad = activityManager.findFormById(dto.getActividad());
			list.add(actividad);
			
		}
		return list;
	}

	@Transactional
	public void inscribirse(int integrante, int actividad, String fechaIni,
			String fechaFin) {

		
		IntegranteActividadForm form = new IntegranteActividadForm();
		form.setActividad(actividad);
		form.setIntegrante(integrante);
		form.setFechaIni(fechaIni);
		form.setFechaFin(fechaFin);
		
			inscribirse(form);	
		
	}

	@Transactional
	public void inscribirse(IntegranteActividadForm form) {
		IntegranteActividades dto = IntegranteActividadMapper.getIntegranteActividad(form);

		if (esUsuarioInscripto(form.getActividad(),form.getIntegrante())){
			
		} else  {
			integratorActivityDao.save(dto);	
		}
		
	}

	@Transactional
	public boolean esUsuarioInscripto(int actividad, int integrante) {
		boolean inscripto = true;
		
		IntegranteActividades dto = integratorActivityDao.findByActivityUser(actividad, integrante);
		if (dto == null  || dto.getId() == 0  ){
			//el usuario no esta inscripto
			inscripto = false;
		}
		
		return inscripto;
	}

}