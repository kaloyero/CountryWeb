

package com.country.test.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.country.hibernate.model.TipoVehiculo;
import com.country.hibernate.model.Unidad;
import com.country.hibernate.model.Vehiculo;
import com.country.services.VehicleManager;

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
public class VehicleManagerTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
    private VehicleManager vehicleManager;
	
	@Test
	@Rollback(false)
	public void create() {
		System.out.println("Prueba: Crear un nuev vehivulo ");
			
		Vehiculo dto = new Vehiculo();
		
		dto.setCilindrada("250");
		dto.setCodigo("120");
		dto.setDescripcion("zaraza");
		
	
		Unidad unidad = new Unidad();
		unidad.setId(1);
		dto.setUnidad(unidad);
		TipoVehiculo tipeVeh = new TipoVehiculo();
		tipeVeh.setId(1);
		dto.setTipoVehiculo(tipeVeh);
		

		vehicleManager.save(dto);
		
    }	

	
}