package com.country.services;

import java.util.List;

import com.country.form.AvisoCategoriaForm;
import com.country.form.TipoForm;
import com.country.hibernate.model.AvisoCategoria;

public interface NotificationCategoryManager extends AbstractManager<AvisoCategoria>{

	AvisoCategoria findById(Integer id);
	
	AvisoCategoriaForm findFormById(int id);

	public void save(AvisoCategoriaForm form);
	
	public void update(AvisoCategoriaForm form);
	
	/**
	 * Tgrae la lista de avisos categorias con la descripcion del precio y los dias de publicacion
	 * 
	 * @return
	 */
	List<TipoForm> listAllCategoriesDescription(); 

}
