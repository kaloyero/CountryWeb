package com.country.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.country.services.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		
		String txt = homeService.getText();
		  //Obtain the session object, create a new session if doesn't exist
        HttpSession session = request.getSession(true);
        session.setAttribute("TipoDeUsuario", "Admin");
       
		model.addAttribute("serverTime", txt );
		
		return "index";
	}

	public HomeService getHomeService() {
		return homeService;
	}

	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}
	
}
