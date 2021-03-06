package com.country.test.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.country.hibernate.model.Concepto;
import com.country.hibernate.model.Tarifa;
import com.country.services.ConceptManager;

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
public class ConceptManagerTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
    private ConceptManager conceptManager;

	@Test
	@Rollback(false)
	public void createConcept() {
		Concepto dto =  new Concepto();
		dto.setDescripcion("descripcion");
		dto.setFechaComienzo(new Date(20130404));
		dto.setFechaFin(new Date(20130404));
		dto.setNombre("nombre");
		List<Tarifa> tarifas = new ArrayList<Tarifa>();
		Tarifa tari = new Tarifa();
		tari.setConcepto(dto);
		tari.setFechaComienzo(new Date(20130404));
		tari.setFechaFin(new Date(20130404));
		tari.setImporte(12.0);
		tarifas.add(tari);
		dto.setTarifas(tarifas);
		
		conceptManager.save(dto);
		
	}	
    
}