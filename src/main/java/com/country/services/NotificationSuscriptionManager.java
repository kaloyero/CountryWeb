package com.country.services;

import java.util.List;

import com.country.form.AvisoCategoriaForm;
import com.country.form.IntegranteForm;
import com.country.hibernate.model.AvisoSuscripcion;

public interface NotificationSuscriptionManager extends AbstractManager<AvisoSuscripcion>{

	/**
	 * Este metodo devuelve todas las aviso categorias  (FORM) que esta suscripto el integrante especifico 
	 * 
	 * @param id de Integrante
	 * @return lista de avisos categoria
	 */
	List<AvisoCategoriaForm> findAllCategoriesByIntegratorId(Integer id);

	/**
	 * Este metodo devuelve todos los Integrantes(FORM) que estan suscriptos a el aviso categoria. 
	 * 
	 * @param id de aviso categoria
	 * @return lista de Integrantes
	 */
	List<IntegranteForm> findAllIntegrantorFormByNotificationId(Integer id);

	
	/**
	 * Inscribirce a un aviso
	 * 
	 * @param aviso
	 * @param integrante
	 * @return
	 */
	boolean inscribirseAviso(int aviso, int integrante); 
	
	/**
	 * Desinscribirce a un aviso
	 * 
	 * @param aviso
	 * @param integrante
	 * @return
	 */
	boolean desinscribirseAviso(int aviso, int integrante);
	
	/**
	 * Este servicio devielve TRUE si el usuario esta inscripto o FALSE si no lo esta.
	 * 
	 * @param categoria
	 * @param integrante
	 * @return
	 */
	public boolean esUsuarioInscripto(int categoria, int integrante);
	
}
