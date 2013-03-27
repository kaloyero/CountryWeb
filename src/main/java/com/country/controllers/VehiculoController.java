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

import com.country.form.VehiculoForm;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.Vehiculo;
import com.country.mappers.VehiculoMapper;
import com.country.services.TypeVehicleManager;
import com.country.services.UnitManager;
import com.country.services.VehicleManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/vehiculo")
public class VehiculoController {

	@Autowired
	private VehicleManager vehicleManager;
	
	@Autowired
	private UnitManager unitManager;
	
	@Autowired
	private TypeVehicleManager typeVehicleManager;


	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		VehiculoForm vehiculo = new VehiculoForm();
		model.addAttribute("VEHICULO", vehiculo);
		model.addAttribute("unidades", unitManager.listAll());
		model.addAttribute("tipoVehiculo", typeVehicleManager.listAll());
		
		return "vehiculo";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "VEHICULO") VehiculoForm vehiculoForm,
			BindingResult result) throws ParseException {
		
		vehicleManager.save(VehiculoMapper.getvehiculo(vehiculoForm));
				return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
	
		Vehiculo vehiculo =vehicleManager.findById(id);
		VehiculoForm form = (VehiculoForm) VehiculoMapper.getForm(vehiculo);
		model.addAttribute("VEHICULO", form);
		model.addAttribute("unidades", unitManager.listAll());
		model.addAttribute("tipoVehiculo", typeVehicleManager.listAll());

		return "forms/vehiculoForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "VEHICULO") VehiculoForm vehiculoForm,@PathVariable int id,
			BindingResult result) throws ParseException {
		vehicleManager.update(VehiculoMapper.getvehiculo(vehiculoForm));
		return "success";
		

	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();

			for (Vehiculo vehiculo : vehicleManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(vehiculo.getId()));
				row.add(vehiculo.getCodigo());
				row.add(vehiculo.getDescripcion());
				dataTable.getAaData().add(row);
			}

           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("2");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}
