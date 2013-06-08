package com.country.controllers;


import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.country.hibernate.model.Mensaje;
import com.country.services.MessageManager;
import com.country.services.NewsManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/mensaje")
public class MensajeController {

	@Autowired
	private MessageManager mensajeManager;
	
	@RequestMapping(value = "/listaPropietario",method = RequestMethod.GET)
	public @ResponseBody  JSONObject showMessageList(ModelMap model) {

		
		List<Mensaje> mensajes =mensajeManager.listAll();

		JSONArray mensajeJsonArray = new JSONArray();
		for ( Mensaje mensaje : mensajes) {
			JSONObject mensajeJson=new JSONObject();
			mensajeJson.put("titulo",mensaje.getAsunto());
			mensajeJson.put("descripcion",mensaje.getEstado());
			mensajeJson.put("categoria",mensaje.getCategoria().getNombre());
			mensajeJson.put("autor",mensaje.getIntegrante().getPersona().getApellido() + " Unidad " + mensaje.getIntegrante().getUnidad().getCode());

			mensajeJsonArray.add(mensajeJson);
		};

		JSONObject collectionArray = new JSONObject();
		collectionArray.put("mensajes", mensajeJsonArray);
		return collectionArray;
		
	}

	@RequestMapping(value = "/listaMisMensajes",method = RequestMethod.GET)
	public @ResponseBody  JSONObject showMyMessages(ModelMap model) {
		return showMessageList(model);
	}


}
