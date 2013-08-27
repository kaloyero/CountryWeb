package com.country.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.DateUtil;
import com.country.common.GenericDao;
import com.country.common.SessionUtil;
import com.country.common.TipoMensajes;
import com.country.form.MensajeForm;
import com.country.hibernate.dao.IntegratorDao;
import com.country.hibernate.dao.MessageDao;
import com.country.hibernate.dao.MessageDetailDao;
import com.country.hibernate.model.Integrante;
import com.country.hibernate.model.Mensaje;
import com.country.hibernate.model.MensajeDetalles;
import com.country.mappers.MensajeDetalleMapper;
import com.country.mappers.MensajeMapper;
import com.country.services.MessageManager;
import com.country.session.ConfigurationData;
import com.country.session.SessionData;

@Service("messageManager")
public class MessageManagerImpl extends AbstractManagerImpl<Mensaje> implements
		MessageManager {

	@Autowired
	private MessageDao messageDao;

	@Autowired
	private MessageDetailDao messageDetailDao;

	@Autowired
	private IntegratorDao integratorDao;

	public static final String ACTION_CLOSE = "CLOSE";

	protected GenericDao<Mensaje, Integer> getDao() {
		return messageDao;
	}

	@Transactional
	private Mensaje findById(Integer id) {
		Mensaje dto = messageDao.findById(id);
		dto.getDetalles().size();
		return dto;
	}

	@Transactional
	public MensajeForm findFormById(Integer id) {
		Mensaje dto = findById(id);

		MensajeForm form = (MensajeForm) MensajeMapper.getForm(dto);
		form.setDetalles(MensajeMapper.getDetalles(dto.getDetalles()));

		return form;
	}

	@Transactional
	public void save(MensajeForm form) {

		// Seteo el empleado
		if (SessionUtil.isEmployeePerson(SessionData.getTipoUsuario())) {
			form.setIdEmpleado(SessionData.getEmpleadoId());
		} else {
			form.setIdEmpleado(ConfigurationData.getUSUARIO_DEFAULT_RECLAMOS());
		}

		//Seteo el integrante
		if (SessionUtil.isIntegrantePerson( SessionData.getTipoUsuario())){
			form.setIdIntegrante(SessionData.getIntegranteId());	
		}

		//Mapeo el mensaje
		Mensaje dto = MensajeMapper.getMensaje(form);
		
		//Seteo el estado inicial del mensaje
		dto.setEstado(getNextStatus(dto.getTipo(), dto.getEstado(), ""));
		// Seteo la resolucion en blanco
		dto.setResolucion("");

		// guarda el mensaje
		messageDao.save(dto);

		// GUARDO EL DETALLE
		// Si el que envia el mensaje es el administrador tiene que ver si lo
		// envia como ADM o como Integrante.
		int idPersona = SessionData.getPersonaId();
		if (SessionUtil.isEmployeePerson(SessionData.getTipoUsuario())) {
			if (!form.isEnvio()) {
				Integrante inte = integratorDao
						.findById(form.getIdIntegrante());
				idPersona = inte.getPersona().getId();
			}
		}
		MensajeDetalles detalle = MensajeDetalleMapper.getMensajeDetalle(
				dto.getId(), form.getRespuesta(), form.getTipo(), idPersona);
		messageDetailDao.save(detalle);
	}

	@Transactional
	public void update(MensajeForm form) {

		// Guardo el Detalle
		MensajeDetalles detalle = MensajeDetalleMapper.getMensajeDetalle(
				form.getId(), form.getRespuesta(), form.getTipo(),
				SessionData.getPersonaId());
		messageDetailDao.save(detalle);

		// Toma el nuevo estado
		// TODO ver de que forma puedo tomar de la session si es Admin o
		// Propietario
		String newStatus = getNextStatus(form.getTipo(), form.getEstado(),
				form.getAccion());
		// actualiza el estado
		messageDao.updateStatus(form.getId(), form.getCategoria(), newStatus);

	}

	@Transactional
	public void closeMessage(MensajeForm form) {

		// Toma el nuevo estado
		String newStatus = getNextStatus(form.getTipo(), form.getEstado(),
				ACTION_CLOSE);
		// Utilizo la fecha actual para cerrar
		Date closeDate = DateUtil.getDateToday();

		// actualiza el estado
		messageDao.closeMessage(form.getId(), newStatus, closeDate,
				form.getRespuesta());

	}

	public List<Mensaje> getMessajesCategoryType(String type) {
		List<Mensaje> list = messageDao.findAllByProperty("tipo", type);
		return list;
	}

	private String getNextStatus(String typeMessage, String estado,
			String accion) {
		String nextStatus = TipoMensajes.STATUS_ERROR;

		// Si es un mensaje de tipo reclamo
		if (TipoMensajes.TYPE_MESSAGE_RECLAMO.equalsIgnoreCase(typeMessage)) {
			nextStatus = getNextStatusClaim(estado, accion);
		}

		return nextStatus;
	}

	private String getNextStatusClaim(String estado, String accion) {
		String nextStatusClaim = TipoMensajes.STATUS_ERROR;

		// Si el mensaje no tiene un estado inicial lo pone como A: ABIERTO
		if (StringUtils.isBlank(estado)) {
			nextStatusClaim = TipoMensajes.STATUS_INIT;
		} else if (ACTION_CLOSE.equals(accion)) {
			nextStatusClaim = TipoMensajes.STATUS_CLOSE;
		} else if (TipoMensajes.STATUS_IN.equals(accion)) {
			nextStatusClaim = TipoMensajes.STATUS_IN;
		} else {
			nextStatusClaim = TipoMensajes.STATUS_OUT;
		}

		return nextStatusClaim;
	}

	@Transactional
	public List<MensajeForm> listAllForms() {
		List<MensajeForm> list = new ArrayList<MensajeForm>();
		List<Mensaje> mensajes = messageDao.findAll();

		for (Mensaje mensaje : mensajes) {
			MensajeForm form = MensajeMapper.getForm(mensaje);
			form.setCantidadDestalles(mensaje.getDetalles().size());
			form.setDetalles(MensajeMapper.getDetalles(mensaje.getDetalles()));

			list.add(form);
		}
		return list;
	}

}