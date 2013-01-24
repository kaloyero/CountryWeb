package com.country.test.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.country.hibernate.model.Emprendimiento;
import com.country.hibernate.model.Unidad;
import com.country.services.TownManager;
import com.country.services.UnitManager;

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
public class UnitManagerTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
    private UnitManager unitManager;
	@Autowired
    private TownManager townManager;
	
	@Test
	@Rollback(false)
	public void create() {
		System.out.println("Prueba: Crear una nueva unidad");
			
		Unidad dto = new Unidad();
		dto.setDescription("description");
		dto.setCode("code");
		Emprendimiento emp = new Emprendimiento();
		emp.setId(1);
		dto.setBusiness(emp);
		unitManager.save(dto);
		
		
		
    }	

	
}