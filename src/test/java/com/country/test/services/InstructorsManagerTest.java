package com.country.test.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.country.hibernate.model.Instructor;
import com.country.services.InstructorManager;

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
public class InstructorsManagerTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
    private InstructorManager instructorManager;

	@Test
	public void findAll() {
		System.out.println("Prueba de tomar lista de actividades");

		List<Instructor> list = instructorManager.listAll();
		
		for (Instructor instructor : list) {
			System.out.println(instructor.getFechaComienzo());
		}
		Assert.assertEquals(list.size(),0);
    }	
    
}