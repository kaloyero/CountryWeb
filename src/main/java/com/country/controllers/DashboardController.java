package com.country.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.country.common.Constants;
import com.country.form.MensajeForm;
import com.country.hibernate.model.Integrante;
import com.country.hibernate.model.MensajeDetalles;
import com.country.hibernate.model.Noticia;
import com.country.hibernate.model.Usuario;
import com.country.services.ConceptManager;
import com.country.services.IntegratorManager;
import com.country.services.MessageDetailManager;
import com.country.services.MessageManager;
import com.country.services.NewsManager;
import com.country.services.PriceManager;
import com.country.services.ResourceManager;
import com.country.services.UserManager;
import com.country.session.UsuarioInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {

	@Autowired
	private UserManager userManager;
	@Autowired
	private IntegratorManager integratorManager;
	
	@Autowired
	private ConceptManager conceptManager;

	@Autowired
	private ResourceManager recursoManager;

	@Autowired
	private PriceManager priceManager;

	@Autowired
	private NewsManager newsManager;

	@Autowired
	private MessageManager mensajeManager;
	
	@Autowired
	private MessageDetailManager messageDetailManager;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		System.out.println("Prueba");

		return "Propietario/index";
	}

	@RequestMapping(value = "/sideBar", method = RequestMethod.GET)
	public String showSideBar(ModelMap model) {
		System.out.println("Prueba2");

		return "Propietario/sidebar";
	}

	@RequestMapping(value = "/listaPropietario",method = RequestMethod.GET)
	public @ResponseBody  JSONObject showMainContent(ModelMap model, HttpServletRequest request) {
		//JSONArray dashboard = new JSONArray();
		 HttpSession session = request.getSession(true);
	     session.setAttribute("TipoDeUsuario", "Propietario");
	     session.setAttribute("InfoUsuario", getUserData());
	      
		List<Noticia> noticias =newsManager.listAll();
		JSONArray noticiasJsonArray = new JSONArray();
		//JSONObject noticiasJson=new JSONObject();
		for ( Noticia noticia : noticias) {
			JSONObject noticiasJson=new JSONObject();
   		    System.out.println("Dentro1!!  " + noticia.getTitulo());
   		    noticiasJson.put("titulo",noticia.getTitulo());
   		    noticiasJson.put("descripcion",noticia.getTexto());
   		    noticiasJson.put("categoria",noticia.getCategoria().getNombre());
   		    noticiasJson.put("autor","Admin");

   		    noticiasJsonArray.add(noticiasJson);
		};
		
		List<MensajeForm> mensajes =mensajeManager.listAllForms();
	
		JSONArray mensajeJsonArray = new JSONArray();
		for ( MensajeForm mensaje : mensajes) {
			JSONObject mensajeJson=new JSONObject();
			mensajeJson.put("titulo",mensaje.getAsunto());
			MensajeDetalles mensa=messageDetailManager.getLastDetailMessage(mensaje.getId());
			mensajeJson.put("descripcion",mensa.getMensajeDetalle());
			mensajeJson.put("categoria",mensaje.getCategoriaDescripcion());
			mensajeJson.put("autor",mensaje.getIntegranteNombre()); 
			//+ " Unidad " + mensaje.getIntegrante().getUnidad().getCode());

			mensajeJsonArray.add(mensajeJson);
		};
		JSONObject dashboard = new JSONObject();
		dashboard.put("noticias", noticiasJsonArray);
		dashboard.put("mensajes", mensajeJsonArray);

		return dashboard;
	}
	
	private UsuarioInfo getUserData(){
		UsuarioInfo data = new UsuarioInfo();
		Usuario us = userManager.findById(1);
		//Info del usuario
		data.setUsuarioId(us.getId());
		data.setNombreUsuario(us.getNombreUsuario());
		
		//Seteo q es un integrante
		data.setTipoUsuario(Constants.PERSONA_INTEGRANTE);
		Integrante integrante = integratorManager.getIntegratorByIdUser(us.getId());
		data.setIntegranteId(integrante.getId());
		data.setPersonaId(integrante.getPersona().getId());
		
		return data;
	}
}
