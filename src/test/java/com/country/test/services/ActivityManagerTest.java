package com.country.test.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Asignacion;
import com.country.hibernate.model.Concepto;
import com.country.hibernate.model.Cronograma;
import com.country.hibernate.model.Instructor;
import com.country.hibernate.model.Persona;
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

//	@Test
//	public void findAll() {
//		System.out.println("Prueba de tomar lista de actividades");
//
//		List<Actividad> list = activityManager.listAll();
//		
//		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//			Actividad actividad = (Actividad) iterator.next();
//			System.out.println(actividad.getCronogramas().size());
//			for (Cronograma cronos : actividad.getCronogramas()) {
//				System.out.println("IdCronos" +cronos.getId());
//			} 
//		} 
//		
//		Assert.assertEquals(list.size(),0);
//    }	
//	
//	@Test
//	public void insert() {
//        System.out.println("@BeforeClass Esto se ejecuta ANTES de que empiece a corre la CLASE de test");
//		System.out.println("Prueba de Insert");
//		String testName = "Prueba Futbol";
//		Actividad row = new Actividad();
//		//row.setId(1);
//		row.setNombre(testName);
//		row.setFechaFin(new Date(2012,12,12));
//		row.setFechaComienzo(new Date(2012,12,12));
//		Concepto concepto = new Concepto();
//		concepto.setId(2);
//		Cronograma crono = new Cronograma();
//		crono.setActividad(row);
//		crono.setId(4);
//		crono.setDiaSemana(14);
//		crono.setDuracion(12);
//		crono.setHoraInicio(13);
//		Cronograma crono2 = new Cronograma();
//		crono2.setActividad(row);
//		row.setConcepto(concepto);
//		List<Cronograma> cronos = new ArrayList<Cronograma>();
//		cronos.add(crono);
//		cronos.add(crono2);
//		row.setCronogramas(cronos);
//		
//		Asignacion asignacion = new Asignacion();
//		asignacion.setFechaComienzo(new Date(2012,12,12));
//		asignacion.setFechaFin(new Date(2012,12,12));
//		asignacion.setActividad(row);
//		Instructor instructor = new Instructor();
//		instructor.setFechaComienzo(new Date(2012,12,12));
//		instructor.setFechaFin(new Date(2012,12,12));
//		Persona persona = new Persona();
//		persona.setApellido("masciotra");
//		persona.setNombre("Ale");
//		persona.setDtNacimiento(new Date(2012,12,12));
//		persona.setSexo("M");
//		instructor.setPersona(persona);
//		asignacion.setInstructor(instructor);
//		List <Asignacion> asignaciones = new ArrayList<Asignacion>();
//		asignaciones.add(asignacion);
//		row.setAsignaciones(asignaciones);
//		
//		
//		Integer pk = activityManager.save(row);
//		Actividad act = activityManager.findById(pk);
//		List<Cronograma> cronos2 = act.getCronogramas();
//		System.out.println(cronos2.size());
//	}

    
}