

package com.country.test.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.country.hibernate.model.Concepto;
import com.country.hibernate.model.Recurso;
import com.country.hibernate.model.TipoRecurso;
import com.country.services.ResourceManager;

/**
 * TODO AbstractTransactionalJUnit4SpringContextTests
 * 
 * Para tener en cuenta
 * 
 * Pay attention that our class extends the AbstractTransactionalJUnit4SpringContextTests from org.springframework.test.context.junit4. 
 * By extending this class, we give our methods transactional support at the class level. If we did not do this, and we wanted 
 * transactional support, we would have to either annotate our methods with @Transactional or configure our transaction manager with 
 * the @TransactionConfiguration annotation.
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/appServlet/servlet-context-test.xml"})
public class ResourcesManagerTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
    private ResourceManager resourceManager;
	
	@Test
	@Rollback(false)
	public void create() {
		System.out.println("Prueba: Crear un nuevo Recurso");
			
		Recurso dto = new Recurso();
		
		dto.setDescripcion("zaraza");
		dto.setMaxTiempoReserv(11);
		dto.setNombre("nombre");
		
		TipoRecurso tipoRec = new TipoRecurso(); 
		tipoRec.setId(1);
		dto.setTipoRecurso(tipoRec);

		Concepto concepto = new Concepto();
		concepto.setId(2);
		dto.setConcepto(concepto);

		
		resourceManager.save(dto);
		
    }	

	
}