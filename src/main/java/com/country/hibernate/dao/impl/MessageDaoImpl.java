package com.country.hibernate.dao.impl;

import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.MessageDao;
import com.country.hibernate.model.Mensaje;

@Repository("messageDao")
public class MessageDaoImpl extends GenericDaoImpl<Mensaje, Integer> implements MessageDao{

	@Override
	protected Class<Mensaje> getEntityClass() {
		return Mensaje.class;
	}

	public void updateStatus(int idMensaje, int category, String status) {
		Mensaje msj = findById(idMensaje);
		msj.setEstado(status);
		if (category != 0){
			msj.getCategoria().setId(category);
		}
		update(msj);
	}

	public void closeMessage(int idMensaje, String status, Date closeDate, String resolucion) {
		Mensaje msj = findById(idMensaje);
		msj.setEstado(status);
		msj.setFechaCierre(closeDate);
		msj.setResolucion(resolucion);
		update(msj);
	}

    @Transactional
    public int getNumReclamosByIntegrante(int idIntegrante, String tipoMensaje,
			String envioPor, String estado) {
    	
        DetachedCriteria criteria = createDetachedCriteria();
        criteria.add(Restrictions.eq("integrante.id", idIntegrante));
        criteria.add(Restrictions.eq("tipoMensaje", tipoMensaje));
        if (envioPor != null)
        	criteria.add(Restrictions.eq("envio", envioPor));
        if (estado != null)
        	criteria.add(Restrictions.eq("estado", estado));
        return (Integer) criteria.getExecutableCriteria(getSession()).setProjection(Projections.rowCount()).uniqueResult();
    	
    }

	
}
