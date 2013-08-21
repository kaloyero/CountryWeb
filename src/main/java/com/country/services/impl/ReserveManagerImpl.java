package com.country.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.form.EventoForm;
import com.country.form.IntegranteForm;
import com.country.form.RecursoForm;
import com.country.form.ReservaForm;
import com.country.hibernate.dao.ReserveDao;
import com.country.hibernate.model.Reserva;
import com.country.mappers.ReserveMapper;
import com.country.services.EventManager;
import com.country.services.IntegratorManager;
import com.country.services.PriceManager;
import com.country.services.ReserveManager;
import com.country.services.ResourceManager;

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
	private IntegratorManager integratorManager;
	
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
		
		RecursoForm recForm = resourceManager.getResourceForm(dto.getRecurso());
		IntegranteForm integranteForm = integratorManager.findFormById(dto.getIntegrante());
		EventoForm eventoForm = eventManager.findFormById(dto.getEvento()); 
				
		form = (ReservaForm) ReserveMapper.getForm(dto);
		//Seteo el recurso, integrante y evento.
		form.setEvento(eventoForm);
		form.setRecurso(recForm);
		form.setIntegrante(integranteForm);
		
		return form;
	}

	
	public void save(ReservaForm form) {
		
		Reserva dto = ReserveMapper.getReserva(form);

		if (resourceManager.checkReserveResource(dto.getRecurso(), dto.getFecha(), dto.getHoraIni(), dto.getDuracion())){
			save(dto);
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
		List<Reserva> reservas = reserveDao.findAll();

		for (Reserva res : reservas) {
			RecursoForm recForm = resourceManager.getResourceForm(res.getRecurso());
			IntegranteForm integranteForm = integratorManager.findFormById(res.getIntegrante());
			EventoForm eventoForm = eventManager.findFormById(res.getEvento()); 
					
			ReservaForm form = (ReservaForm) ReserveMapper.getForm(res);
			//Seteo el recurso, integrante y evento.
			form.setEvento(eventoForm);
			form.setRecurso(recForm);
			form.setIntegrante(integranteForm);

			list.add(form);
		}
		
		return list;
	}
}
