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

import com.country.form.IntegranteForm;
import com.country.hibernate.model.DataTable;
import com.country.services.IntegratorManager;
import com.country.services.TypeDocumentManager;
import com.country.services.TypeTelephoneManager;
import com.country.services.UnitManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/integrante")
public class IntegranteController {

	@Autowired
	private IntegratorManager integranteManager;
	
	@Autowired
	private UnitManager unidadManager;
	
	@Autowired
	private TypeDocumentManager tipoDocumentoManager;

	@Autowired
	private TypeTelephoneManager tipoTelephoneManager;


	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		IntegranteForm integrante = new IntegranteForm();

		model.addAttribute("INTEGRANTE", integrante);
		model.addAttribute("unidades", unidadManager.listAll());
		model.addAttribute("tipoDocumento", tipoDocumentoManager.listAll());
		model.addAttribute("tipoTelefono", tipoTelephoneManager.listAll());
		
		return "integrante";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "INTEGRANTE") IntegranteForm integranteForm,
			BindingResult result) throws ParseException {
		
		integranteManager.save(integranteForm);
				return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
	
		IntegranteForm form = integranteManager.findFormById(id);
		
		model.addAttribute("INTEGRANTE", form);
		model.addAttribute("unidades", unidadManager.listAll());
		model.addAttribute("tipoDocumento", tipoDocumentoManager.listAll());
		model.addAttribute("tipoTelefono", tipoTelephoneManager.listAll());
		
		return "forms/integranteForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "INTEGRANTE") IntegranteForm integranteForm,@PathVariable int id,
			BindingResult result) throws ParseException {
		integranteManager.update(integranteForm);
		return "success";
		

	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();

			for (IntegranteForm integrante : integranteManager.listAllFormsComplete()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(integrante.getId()));
				row.add(integrante.getUsuario().getUsuario());
				row.add(integrante.getPersona().getNombre() + " " + integrante.getPersona().getApellido());
				row.add(integrante.getPersona().getNroDoc());
				row.add(integrante.getUnidadCode());
				String tel = "";
				if (! integrante.getPersona().getListaTelefonos().isEmpty()){
					tel = integrante.getPersona().getListaTelefonos().get(0).getTipoTelefonoNombre() + " (" +  integrante.getPersona().getListaTelefonos().get(0).getCodigoPais() + " " + integrante.getPersona().getListaTelefonos().get(0).getCodigoArea() + ") " +   integrante.getPersona().getListaTelefonos().get(0).getNumero();
				}
				row.add(tel);
				if (integrante.isEstado()){
					row.add("ACTIVO");	
				} else {
					row.add("INACTIVO");
				}
				//TODO agregar acciones de 'Activar/desactivar integrante', 'eliminar integrante'. 
				row.add("");
				dataTable.getAaData().add(row);
			}

           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("5");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}
