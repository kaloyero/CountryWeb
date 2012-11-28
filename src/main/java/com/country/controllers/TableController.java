package com.country.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.DataTable;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TableController {
	

	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws JSONException 
	 * @throws IOException 
	 */
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();
           List <String> row1 =new ArrayList<String>();;

           row1.add("a");
           row1.add("b");
           dataTable.getAaData().add(row1);
           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("2");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}


	
}
