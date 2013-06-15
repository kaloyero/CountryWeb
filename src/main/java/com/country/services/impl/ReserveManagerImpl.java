package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.form.EventoForm;
import com.country.form.IntegranteForm;
import com.country.form.RecursoForm;
import com.country.form.ReservaForm;
import com.country.hibernate.dao.ReserveDao;
import com.country.hibernate.model.RecursoDisponibilidad;
import com.country.hibernate.model.Reserva;
import com.country.hibernate.model.Tarifa;
import com.country.mappers.EventoMapper;
import com.country.mappers.RecursoMapper;
import com.country.mappers.ReserveMapper;
import com.country.services.IntegratorManager;
import com.country.services.PriceManager;
import com.country.services.ReserveManager;

@Service("reserveManager")
public class ReserveManagerImpl extends AbstractManagerImpl<Reserva> implements ReserveManager{

	@Autowired
    private ReserveDao reserveDao;

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
		
		//TODO no esta trayendo las disponibiledades. Es necesario?
		Tarifa tarifa = priceManager.getLastPriceByConcept(dto.getRecurso().getConcepto().getId());
		RecursoForm recForm = RecursoMapper.getForm(dto.getRecurso(),tarifa.getImporte(), new ArrayList<RecursoDisponibilidad>());
		IntegranteForm integranteForm = integratorManager.findFormById(dto.getIntegrante());
		EventoForm eventoForm = (EventoForm) EventoMapper.getForm(dto.getEvento());
				
		form = (ReservaForm) ReserveMapper.getForm(dto,recForm , integranteForm,eventoForm );
		
		return form;
	}


	/**
	 * Este metodo devuelve todas las reservas que pertenecen a una unidad especifica 
	 * 
	 * @param id de unidad
	 * @return lista de reservas
	 */
	public List<Reserva> findListReservationByUnit(Integer id) {
		List<Reserva> list = new ArrayList<Reserva>();
		list = reserveDao.findAllByProperty("unidad", id);
		return list;
	}

	/**
	 * Este metodo devuelve todas las reservas que pertenecen a un recurso especifico 
	 * 
	 * @param id de recurso
	 * @return lista de reservas
	 */
	public List<Reserva> findListReservationByResource(Integer id) {
		List<Reserva> list = new ArrayList<Reserva>();
		list = reserveDao.findAllByProperty("recurso", id);
		return list;
	}

}
