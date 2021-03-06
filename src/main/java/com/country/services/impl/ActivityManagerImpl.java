package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.ActividadForm;
import com.country.hibernate.dao.ActivityDao;
import com.country.hibernate.dao.AsignationDao;
import com.country.hibernate.dao.ConceptDao;
import com.country.hibernate.dao.PriceDao;
import com.country.hibernate.dao.ScheduleDao;
import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Asignacion;
import com.country.hibernate.model.Cronograma;
import com.country.hibernate.model.Tarifa;
import com.country.mappers.ActividadMapper;
import com.country.services.ActivityManager;
import com.country.services.PriceManager;
import com.country.session.SessionUsr;

@Service("activityManager")
public class ActivityManagerImpl extends AbstractManagerImpl<Actividad> implements ActivityManager{

	@Autowired
    private ActivityDao activityDao;

	@Autowired
    private ConceptDao conceptDao;

	@Autowired
    private ScheduleDao scheduleDao;
	
	@Autowired
    private PriceDao priceDao;

	@Autowired
    private AsignationDao asignationDao;

	@Autowired
    private PriceManager priceManager;

	
	protected GenericDao<Actividad, Integer> getDao() {
		return activityDao;
	}
	
	@Transactional
	private Actividad findById(Integer id) {
		Actividad act = activityDao.findById(id);
		act.getCronogramas().size();
		act.getAsignaciones().size();
//		act.getIntegrants().size();
		return act;
	}

	@Transactional
	public ActividadForm findFormById(Integer id) {
		ActividadForm form = new ActividadForm();
		
		Actividad dto = findById(id);
		Tarifa tarifa = priceManager.getLastPriceByConcept(dto.getConcepto().getId());
		
		form = (ActividadForm) ActividadMapper.getForm(dto,tarifa);
		
		return form;
	
	}
	
	public List<Asignacion> findAsignacionByIdAct(Integer id) {
		List<Asignacion> list = (List<Asignacion>) asignationDao.findAllByProperty("actividad.id",id);
		return list;
	}
	

	@Transactional
	public int save(Actividad dto, Double tarifa) {		
		int id = 0;		
		id = activityDao.save(dto);
		
		
		for (Asignacion asignacion : dto.getAsignaciones()) {
			asignacion.getActividad().setId(id);
			asignationDao.save(asignacion);
		} 
		scheduleDao.saveList(dto.getCronogramas());
		Tarifa price = new Tarifa();

		price.setConcepto(dto.getConcepto().getId());
		price.setImporte(tarifa);
		price.setFechaComienzo(dto.getFechaComienzo());
		priceDao.save(price);		

		return id;
	}
	
	@Transactional	
	//public void update(Actividad dto, List<Asignacion> asignaciones, Double tarifa) {
	public void update(Actividad dto, List<Asignacion> asignaciones, Double tarifa) {
		List<Cronograma> listCrono = scheduleDao.findAllByProperty("actividad.id", dto.getId());

		for (Cronograma crono : dto.getCronogramas()) {
			boolean insert = true;
			for (Cronograma cronograma : listCrono) {
					
				if (crono.getDiaSemana() == cronograma.getDiaSemana() && crono.getHoraInicio() == cronograma.getHoraInicio()){
					insert = false;
				}
			}
			if (insert){
				scheduleDao.save(crono);
			}			
		}
		
		//Borro los cronogramas q ya no estan
		for (Cronograma cronograma : listCrono) {
			boolean delete = true;
			for (Cronograma crono : dto.getCronogramas()) {
				if (crono.getDiaSemana() == cronograma.getDiaSemana() && crono.getHoraInicio() == cronograma.getHoraInicio() ){
					delete = false;
				}
			}
			if (delete){
				scheduleDao.delete(cronograma);
			}
		}		
		//Agarro la tarifa que viene del form
		Tarifa price = new Tarifa();
		price.setConcepto(dto.getConcepto().getId());
		price.setImporte(tarifa);
		price.setFechaComienzo(dto.getFechaComienzo());

		//si es igual a la ultima no la actualizo, sino la agrego a la lista
		Tarifa tarifaUltima = priceDao.getLastPriceByConcept(dto.getConcepto().getId());
		
		if (tarifaUltima == null || price.getImporte() != tarifaUltima.getImporte()){
			priceDao.save(price);	
		}
		
		for (Asignacion asign : asignaciones) {
			asignationDao.update(asign);
		}

		activityDao.update(dto);
		
	}

	@Transactional
	public List<Actividad> findAllByActivityName(String name) {
		List<Actividad> list = new ArrayList<Actividad>();
		list = activityDao.findAllByProperty("nombre", name);
		return list;
	}
	
	@Transactional
	public List<Actividad> listAllForBook() {
		List<Actividad> actividades = new ArrayList<Actividad>();
		actividades = listAll();
		for (Actividad actividad : actividades) {
			actividad.getCronogramas().size();
		}
		return actividades;
	}

	@Transactional
	public List<ActividadForm> listAllFormsComplete() {
		List<Actividad> actividades = listAll();
		return getFormList(actividades,true,true,true);
	}

	@Transactional
	public List<ActividadForm> getActividadInscriptoBySemana(String fechaDesde) {
		List<Actividad> list = activityDao.getActividadInscriptoByDate(SessionUsr.User().getIntegranteId(), fechaDesde, null, 6);
		return getFormList(list,false,false,false);
	}

	/**
	 * Mapea la lista de actividad a actividadForm
	 * 
	 * @param list
	 * @param tarifa tarifa Si tarifa igual a true, trae la tarifa de la actividad
	 * @param asignacion Si asignacion igual a true, trae las asignaciones de la actividad
	 * @param cronograma Si cronograma igual a true, trae los cronogramas de la actividad
	 * @return
	 */
	private List<ActividadForm>  getFormList (List<Actividad> list,boolean tarifa,boolean asignacion, boolean cronograma){
		List<ActividadForm> listaForm = new ArrayList<ActividadForm>();
		for (Actividad act : list) {
			Tarifa trf =null;
			if (asignacion){
				//Asignaciones
				if (act.getAsignaciones() != null){
					act.getAsignaciones().size();	
				}
			}
			if (cronograma){
				//Cronogramas
				act.getCronogramas().size();
			}
			if (tarifa){
				if (act.getConcepto() != null){
					trf = priceManager.getLastPriceByConcept(act.getConcepto().getId());
				}		
			}

			listaForm.add((ActividadForm) ActividadMapper.getForm(act,trf));
		}
		return listaForm; 
	}

}
