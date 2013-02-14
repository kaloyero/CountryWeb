

package com.country.test.services;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.country.hibernate.model.Recurso;
import com.country.hibernate.model.Reserva;
import com.country.hibernate.model.Unidad;
import com.country.services.ReserveManager;

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
public class ReservationManagerTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
    private ReserveManager reserveManager;
	
	@Test
	@Rollback(false)
	public void create() {
		System.out.println("Prueba: Crear una nueva Reserva");
			
		Reserva dto = new Reserva();
		
		dto.setDescripcion("descripcion");
		dto.setDuracion(15);
		dto.setFecha(new Date(2222));
		dto.setHoraIni(22);

		Recurso recurso = new Recurso();
		recurso.setId(1);
		dto.setRecurso(recurso);

		Unidad unidad = new Unidad();
		unidad.setId(1);
		dto.setUnidad(unidad);
				
		reserveManager.save(dto);
		
    }
	
}