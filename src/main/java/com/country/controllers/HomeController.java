package com.country.controllers;

import java.text.ParseException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.country.common.Constants;
import com.country.common.SessionUtil;
import com.country.form.LoginForm;
import com.country.services.EmployeeManager;
import com.country.services.HomeService;
import com.country.services.UserManager;
import com.country.session.SessionUsr;
import com.country.session.UsuarioInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UserManager userManager;
	@Autowired
	private EmployeeManager employeeManager;
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
        
		model.addAttribute("serverTime", txt );
		
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "loginform") LoginForm form,
			BindingResult result,HttpServletRequest request) throws ParseException {
		
		UsuarioInfo usr = userManager.checkAvaiableUser(form);
		
		if (StringUtils.isBlank(usr.getErrorDescripcion())){
			if (SessionUtil.isEmployeePerson( usr.getTipoUsuario())){
				SessionUsr.Aplicacion().setTipoAplicacion(Constants.TIPO_APLICACION_ADMIN);
				return "index-admin";		
			} else {
				SessionUsr.Aplicacion().setTipoAplicacion(Constants.TIPO_APLICACION_PROPIETARIO);
				return "Propietario/index";
			}
		} else {
			return "loginError";	
		}		
		
	}	

	public HomeService getHomeService() {
		return homeService;
	}

	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

}
