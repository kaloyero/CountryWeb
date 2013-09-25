package com.country.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.DateUtil;
import com.country.common.GenericDao;
import com.country.common.SessionUtil;
import com.country.form.EventoForm;
import com.country.form.PersonaForm;
import com.country.form.RecursoForm;
import com.country.form.ReservaForm;
import com.country.hibernate.dao.ReserveDao;
import com.country.hibernate.model.Reserva;
import com.country.mappers.ReserveMapper;
import com.country.services.EventManager;
import com.country.services.PersonManager;
import com.country.services.PriceManager;
import com.country.services.ReserveManager;
import com.country.services.ResourceManager;
import com.country.session.SessionUsr;

@Service("reserveManager")
public class ReserveManagerImpl extends AbstractManagerImpl<Reserva> implements ReserveManager{

	@Autowired
    private ReserveDao reserveDao;

	@Autowired
    private ResourceManager resourceManager;
	
	@Autowired
    private EventManager eventManager;
	
	@Autowired
    private PriceManager priceManager;

	@Autowired
	private PersonManager personManager;
	
	protected GenericDao<Reserva, Integer> getDao() {
		return reserveDao;
	}

	private Reserva findById(Integer id) {
		Reserva dto = reserveDao.findById(id);
		return dto;
	}
	
	public ReservaForm findFormById(Integer id) {
		ReservaForm form = new ReservaForm();
		
		Reserva dto = findById(id);
		
		form = (ReservaForm) ReserveMapper.getForm(dto);
		
		return form;
	}
	
	public ReservaForm findFormByIdCoplete(Integer id) {
		ReservaForm form = new ReservaForm();
		
		Reserva dto = findById(id);
		form = setForm(dto);

		
		return form;
	}

	@Transactional
	public void save(ReservaForm form) {

		Reserva dto = ReserveMapper.getReserva(form);
		
		//PERSONA que reserva
		int idPersona = SessionUsr.User().getPersonaId();
		if (SessionUtil.isEmployeePerson( SessionUsr.User().getTipoUsuario())){
			if (! form.isEnvioAdm()){
				idPersona = form.getPersonId();
			}	
		}
		dto.setPersona(idPersona);
		
		if (resourceManager.checkReserveResource(dto.getRecurso(), dto.getFecha(), dto.getHoraIni(), dto.getDuracion())){
			save(dto);
		} else {
			//TODO sacar por error
		}
			
		
	}

	public void update(ReservaForm form) {

		Reserva dto = ReserveMapper.getReserva(form);
		
		if (resourceManager.checkReserveResource(dto.getRecurso(), dto.getFecha(), dto.getHoraIni(), dto.getDuracion())){
			update(dto);
		} else {
			//TODO sacar por error
		}
	}
	

	public List<Reserva> findListReservationByUnit(Integer id) {
		List<Reserva> list = new ArrayList<Reserva>();
		list = reserveDao.findAllByProperty("unidad", id);
		return list;
	}

	public List<Reserva> findListReservationByResource(Integer id) {
		List<Reserva> list = new ArrayList<Reserva>();
		list = reserveDao.findAllByProperty("recurso", id);
		return list;
	}

	public Reserva findResourceBefore(Integer resource, Date fecha, int horaIni) {

		//Tomo la reserva anterior
		Reserva anterior = reserveDao.findResourceAfterBefore(false, resource, fecha, horaIni);
		
		return anterior;
	}

	public Reserva findResourceAfter(Integer resource, Date fecha, int horaIni) {
		//Tomo la reserva posterior
		Reserva posterior = reserveDao.findResourceAfterBefore(true, resource, fecha, horaIni);
		return posterior;
	}

	public List<ReservaForm> listAllFormsComplete() {

		List<ReservaForm> list = new ArrayList<ReservaForm>();
		List<Reserva> reservas = listAll();

		for (Reserva res : reservas) {
			list.add(setForm(res));
		}
		
		return list;
	}
	
	private ReservaForm setForm(Reserva reserva){
		RecursoForm recForm = resourceManager.getResourceForm(reserva.getRecurso());
		PersonaForm personaForm = personManager.findFormById(reserva.getPersona());
		EventoForm eventoForm = eventManager.findFormById(reserva.getEvento()); 
				
		ReservaForm form = (ReservaForm) ReserveMapper.getForm(reserva);
		//Seteo el recurso, persona y evento.
		form.setEvento(eventoForm);
		form.setRecurso(recForm);
		form.setPersona(personaForm);
		
		return form;
	}

	public Reserva findReserveByIdEvent(int event) {
			
		return reserveDao.findEntityByProperty("evento", event);	
	}

	public Integer getReserveNumByPerson() {
		return reserveDao.getReserveNumByPerson(SessionUsr.User().getPersonaId(), DateUtil.getDateTodayDmyFormat());
	}

	public Integer getReserveNumByUnit() {
		return reserveDao.getReserveNumByUnit(SessionUsr.User().getUnidad().getId(), DateUtil.getDateTodayDmyFormat());
	}
}
