package com.country.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.country.form.InstructorForm;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.Instructor;
import com.country.mappers.InstructorMapper;
import com.country.services.CityManager;
import com.country.services.InstructorManager;
import com.country.services.TypeDocumentManager;
import com.country.services.TypeTelephoneManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/instructor")
public class InstructorController {

	@Autowired
	private InstructorManager instructorManager;

	@Autowired
	private TypeDocumentManager tipoDocumentoManager;

	@Autowired
	private TypeTelephoneManager typeTelephoneManager;
	
	@Autowired
	private CityManager cityManager;

	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		InstructorForm instructor = new InstructorForm();
		model.addAttribute("tipoDocumento", tipoDocumentoManager.listAll());
		model.addAttribute("tipoTelefono", typeTelephoneManager.listAll());
		//TODO agregar la ciudad especifica
		model.addAttribute("localidades", cityManager.getTownsByIdCity(1));
		
		model.addAttribute("INSTRUCTOR", instructor);
		
		return "instructor";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "INSTRUCTOR") InstructorForm instructorForm,
			BindingResult result) throws ParseException {
		
		instructorManager.save(instructorForm);
				return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
		InstructorForm form = instructorManager.findFormById(id);
		model.addAttribute("INSTRUCTOR", form);
		model.addAttribute("tipoDocumento", tipoDocumentoManager.listAll());
		model.addAttribute("tipoTelefono", typeTelephoneManager.listAll());
		//TODO agregar la ciudad especifica
		model.addAttribute("localidades", cityManager.getTownsByIdCity(1));
		
		return "forms/instructorForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "INSTRUCTOR") InstructorForm instructorForm,@PathVariable int id,
			BindingResult result) throws ParseException {
		instructorManager.update(instructorForm);
		return "success";

	}
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();

			for (Instructor instructor : instructorManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(instructor.getId()));
				row.add(instructor.getPersona().getNombre() + " " + instructor.getPersona().getApellido());
				row.add(instructor.getPersona().getTipoDoc().getNombre() + " " +  instructor.getPersona().getNroDoc());
				row.add(instructor.getPersona().getEmail());
				String tel = "";
//				for (Telefono telefono : instructor.getPersona().getTelefonos()) {
//					tel = telefono.getTipoTelefono().getNombre() + " " + String.valueOf(telefono.getNumero());
//				}
				row.add(tel);
				dataTable.getAaData().add(row);
			}
 ;
           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("5");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}
