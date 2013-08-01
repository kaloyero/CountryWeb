package com.country.services;

import java.util.List;

import com.country.form.EventoForm;
import com.country.form.IntegranteForm;
import com.country.hibernate.model.EventoIntegrante;

public interface EventIntegratorManager extends AbstractManager<EventoIntegrante>{

	/**
	 * Inscribe al propietario al evento
	 * 
	 * @param evento
	 * @param integrante
	 * @return
	 */
	boolean inscribirseEvento(int evento, int integrante);
	
	/**
	 * Da de baja al propietario del evento
	 * 
	 * @param evento
	 * @param integrante
	 * @return
	 */
	boolean desinscribirseEvento(int evento, int integrante);

	/**
	 * Este metodo devuelve todas las aviso categorias  (FORM) que esta suscripto el integrante especifico 
	 * 
	 * @param id de Integrante
	 * @return lista de avisos categoria
	 */
	List<EventoForm> findAllEventByIntegratorId(Integer id);

	/**
	 * Este metodo devuelve todos los Integrantes(FORM) que estan en el eveto. 
	 * 
	 * @param id de evento
	 * @return lista de Integrantes
	 */
	List<IntegranteForm> findAllIntegrantorFormByEventoId(Integer id);
	
	
	/**
	 * Este servicio devielve TRUE si el usuario esta inscripto o FALSE si no lo esta. 
	 * 
	 * @param evento
	 * @param integrante
	 * @return
	 */
	boolean esUsuarioInscripto(int evento, int integrante);
}
