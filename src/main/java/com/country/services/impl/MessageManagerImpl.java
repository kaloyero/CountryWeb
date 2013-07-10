package com.country.services.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.common.TipoMensajes;
import com.country.form.MensajeForm;
import com.country.hibernate.dao.MessageDao;
import com.country.hibernate.dao.MessageDetailDao;
import com.country.hibernate.model.Integrante;
import com.country.hibernate.model.Mensaje;
import com.country.hibernate.model.MensajeDetalles;
import com.country.mappers.MensajeMapper;
import com.country.services.MessageManager;

@Service("messageManager")
public class MessageManagerImpl extends AbstractManagerImpl<Mensaje> implements MessageManager{

	@Autowired
    private MessageDao messageDao;
	
	@Autowired
    private MessageDetailDao messageDetailDao;

	
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
		
		return form;
	}

	@Transactional
	public void save(MensajeForm form) {
		
		Mensaje dto = MensajeMapper.getMensaje(form);
		
		//Seteo el estado inicial del mensaje
		getNextStatus(dto.getTipo(), dto.getEstado(), "");
		//Seteo la resolucion en blanco
		dto.setResolucion("");
		
		//TODO hacer que tome el integrante real. Crear combo
		Integrante integrante = new Integrante();
		integrante.setId(1);
		dto.setIntegrante(integrante);

		// Guardo los Detalles
		if (dto.getDetalles() != null){
			for (MensajeDetalles detalle : dto.getDetalles()) {
				detalle.setMensaje(dto.getId());
				messageDetailDao.save(detalle);
			}
		}
		
		//guarda el mensaje
		getDao().save(dto);
	}

	@Transactional
	public void update(MensajeForm form) {
		
		Mensaje dto = MensajeMapper.getMensaje(form);
		
		//Seteo el estado inicial del mensaje
		getNextStatus(dto.getTipo(), dto.getEstado(), "");
		//Seteo la resolucion en blanco
		dto.setResolucion("");
		
		//TODO hacer que tome el integrante real. Crear combo
		Integrante integrante = new Integrante();
		integrante.setId(1);
		dto.setIntegrante(integrante);

		// Guardo los Detalles
		if (dto.getDetalles() != null){
			for (MensajeDetalles detalle : dto.getDetalles()) {
				detalle.setMensaje(dto.getId());
				messageDetailDao.save(detalle);
			}
		}
		
		//guarda el mensaje
		getDao().save(dto);
	}
	
	public List<Mensaje> getMessajesCategoryType(String type) {
		List<Mensaje> list = messageDao.findAllByProperty("tipo", type);
		return list;
	}

	private String getNextStatus(String typeMessage,String estado,String accion) {
		String nextStatus = TipoMensajes.STATUS_ERROR;
		
		//Si es un mensaje de tipo reclamo
		if (TipoMensajes.STATUS_ERROR.equalsIgnoreCase(typeMessage)){
			nextStatus = getNextStatusClaim(estado,accion);				 
		}
		
		return nextStatus;
	}

	private String getNextStatusClaim(String estado,String accion) {
		String nextStatusClaim = TipoMensajes.STATUS_ERROR;

		//Si el mensaje no tiene un estado inicial lo pone como A: ABIERTO
		if (StringUtils.isBlank(estado)){
			nextStatusClaim = TipoMensajes.STATUS_INIT;
		}
		
		return nextStatusClaim;
	}

	
}
