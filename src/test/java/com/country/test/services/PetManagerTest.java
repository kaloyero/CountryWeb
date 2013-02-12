package com.country.test.services;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.country.hibernate.model.Mascota;
import com.country.hibernate.model.Raza;
import com.country.hibernate.model.Unidad;
import com.country.services.PetManager;

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
public class PetManagerTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
    private PetManager petManager;
	
	@Test
	@Rollback(false)
	public void create() {
		System.out.println("Prueba: Crear una nueva mascota");
			
		Mascota dto = new Mascota();
		
		dto.setCodigo("codigo");
		dto.setDistincion("distincion");
		dto.setFechaNac(new Date(2222222));
		dto.setNombre("nombre");
		dto.setSexo("M");
		dto.setTamano("1");
		dto.setColor("color");
		
		Raza raza = new Raza();
		raza.setId(1);
		dto.setRaza(raza);

		Unidad unidad = new Unidad();
		unidad.setId(1);
		dto.setUnidad(unidad);
		
		petManager.save(dto);
		
    }	

	
}
