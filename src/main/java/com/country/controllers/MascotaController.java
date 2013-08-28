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

import com.country.form.MascotaForm;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.Mascota;
import com.country.mappers.MascotaMapper;
import com.country.services.PetManager;
import com.country.services.RazaManager;
import com.country.services.UnitManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/mascota")
public class MascotaController {

	@Autowired
	private PetManager petManager;
	
	@Autowired
	private UnitManager unitManager;
	
	@Autowired
	private RazaManager razaManager;

	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		MascotaForm mascota = new MascotaForm();
		model.addAttribute("MASCOTA", mascota);
		model.addAttribute("unidades", unitManager.listAll());
		model.addAttribute("razas", razaManager.listAll());
		
		return "mascota";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "MASCOTA") MascotaForm mascotaForm,
			BindingResult result) throws ParseException {
		
			petManager.save(MascotaMapper.getMascota(mascotaForm));
				return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
	
		Mascota mascota =petManager.findById(id);
		MascotaForm form = (MascotaForm) MascotaMapper.getForm(mascota);
		model.addAttribute("MASCOTA", form);
		model.addAttribute("unidades", unitManager.listAll());
		model.addAttribute("razas", razaManager.listAll());

		return "forms/mascotaForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "MASCOTA") MascotaForm mascotaForm,@PathVariable int id,
			BindingResult result) throws ParseException {
		petManager.update(MascotaMapper.getMascota(mascotaForm));
		return "success";
		

	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();

			for (Mascota mascota : petManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(mascota.getId()));
				row.add(mascota.getCodigo());
				row.add(mascota.getNombre());
				row.add(mascota.getSexo());
				row.add(mascota.getColor());
				row.add(mascota.getTamano());
				row.add(mascota.getRaza().getNombre());
				row.add(mascota.getUnidad().getCode());
				//TODO Acciones
				row.add("");
				dataTable.getAaData().add(row);
			}

           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("2");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}
