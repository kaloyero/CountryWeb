package com.country.test.dao;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.country.hibernate.dao.ActivityDao;
import com.country.hibernate.model.Actividad;

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
public class ActivityDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
    private ActivityDao dao;
	
	@Test
	public void insert() {
		System.out.println("Prueba de Insert");
		
		Actividad row = new Actividad();
		row.setId(1);
		row.setNombre("Futbol");
		row.setFechaFin(new Date(2012,12,12));
		row.setFechaComienzo(new Date(2012,12,12));
		
		Integer pk = dao.save(row);

		Assert.assertEquals(pk, new Integer(1));
    }

	@Test
	public void findAll() {
		System.out.println("Prueba de FIND ALL");
		List<Actividad> lista = dao.findAll();
		
		System.out.println("Expected count list: 1 / Count List: " + lista.size());
		Assert.assertEquals(lista.size(), 0);
    }	
//	
    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("@BeforeClass Esto se ejecuta ANTES de que empiece a corre la CLASE de test");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
         System.out.println("@AfterClass Esto se ejecuta DESPUES de que empiece a corre la CLASE de test");
    }

    @Before
    public void setUp() {
        System.out.println("@Before Esto se ejecuta ANTES de que empiece a correr CADA test");
    }
 
    @After
    public void tearDown() {
        System.out.println("@After Esto se ejecuta DESPUES de que empiece a correr CADA test");
    }    
    
}