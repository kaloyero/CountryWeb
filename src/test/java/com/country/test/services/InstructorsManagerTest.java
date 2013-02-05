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

import com.country.hibernate.model.Direccion;
import com.country.hibernate.model.Instructor;
import com.country.hibernate.model.Localidad;
import com.country.hibernate.model.Persona;
import com.country.hibernate.model.Telefono;
import com.country.hibernate.model.TipoDocumento;
import com.country.hibernate.model.TipoTelefono;
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

//	@Test
//	public void findAll() {
//		System.out.println("Prueba de tomar lista de actividades");
//
//		List<Instructor> list = instructorManager.listAll();
//		
//		for (Instructor instructor : list) {
//			System.out.println(instructor.getFechaComienzo());
//		}
//		Assert.assertEquals(list.size(),0);
//    }	

	@Test
	@Rollback(false)
	public void create() {
		System.out.println("Prueba: Crear un nuevo instructor");
			
		Instructor ins = new Instructor();
		
		ins.setFechaComienzo(new Date(20130101));
		ins.setFechaFin(new Date(20130101));
		Persona per = new Persona();
		per.setApellido("apellido");
		per.setDtNacimiento(new Date(20130101));
		per.setEmail("email@trucho.com");
		per.setNombre("nombre");
		per.setNroDoc("nroDoc");
		per.setSexo("M");
		List<Direccion> listDir = new ArrayList<Direccion>();
		Direccion dir = new Direccion();
		dir.setStreetName("streetName");
		dir.setStreetNumber("Number");
		dir.setPerson(per);
		Localidad loc = new Localidad();
		loc.setId(1);
		dir.setTown(loc);
		listDir.add(dir);
		per.setDirections(listDir);
		List<Telefono> listTel = new ArrayList<Telefono>();
		Telefono tel = new Telefono();
		tel.setNumero(12345);
		tel.setPersona(per);
		TipoTelefono tipotel = new TipoTelefono();
		tipotel.setId(1);
		tel.setTipoTelefono(tipotel);
		listTel.add(tel);
		per.setTelefonos(listTel);
		TipoDocumento tipodoc = new TipoDocumento();
		tipodoc.setId(1);
		per.setTipoDoc(tipodoc);
		
		ins.setPersona(per);
		
		instructorManager.save(ins);
		
    }	

	
}