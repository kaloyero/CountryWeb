package com.country.test.services;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Concepto;
import com.country.services.ActivityManager;

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
public class ActivityManagerTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
    private ActivityManager activityManager;
	
	@Test
	public void insert() {
		System.out.println("Prueba de Insert");
		String testName = "Prueba Futbol";
		Actividad row = new Actividad();
		row.setId(1);
		row.setNombre(testName);
		row.setFechaFin(new Date(2012,12,12));
		row.setFechaComienzo(new Date(2012,12,12));
		Concepto concepto = new Concepto();
		concepto.setNombre("concepto");
		concepto.setFechaComienzo(new Date(2012,12,12));
		row.setConcepto(concepto);
		
		Integer pk = activityManager.createActivity(row);
		Actividad act = activityManager.findById(pk);
		
		Assert.assertEquals(act.getNombre(), testName);
    }

    
}