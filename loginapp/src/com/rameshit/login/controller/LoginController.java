package com.rameshit.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rameshit.login.model.LoginModel;
import com.rameshit.login.service.LoginService;

@Controller
public class LoginController {
	
	public LoginController() {
		System.out.println("----1----");
		System.out.println("In LoginController Constructor...!");
		System.out.println("----2----");
	}

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public ModelAndView weclome() {
		System.out.println("weclome called...in MaV ..!");
		//Creating model and view Obj
		ModelAndView modelAndView = new ModelAndView("login");
		LoginModel model = new LoginModel();
		System.out.println("model : " + model);
		
		model.setUsername("abhilash");
		modelAndView.getModelMap().put("loginModel", model);
		return modelAndView;
	}

/*	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	protected ModelAndView processForm(@ModelAttribute LoginModel loginModel) {
		System.out.println("processForm called");

		System.out.println("loginModel" + loginModel);

		String username = loginModel.getUsername();
		String password = loginModel.getPassword();

		System.out.println("username:" + username);
		System.out.println("password: " + password);

		String viewName = null;

		// to connect DB get the existing username and password

		if ("spring".equals(username) && "spring".equals(password)) {
			viewName = "success";
		} else {
			viewName = "fail";
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		modelAndView.getModel().put("loginModel1", loginModel);
		return modelAndView;
	}
	*/
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	protected ModelAndView processForm(@ModelAttribute LoginModel loginModel) {
		System.out.println("processForm called");
		
		System.out.println("connecting service layer to execute business logic.");
		boolean isValid = loginService.isValidLoginDetials(loginModel);
		
		String viewName = null;
		
		if (isValid) {
			viewName = "success";
		} else {
			viewName = "fail";
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		modelAndView.getModel().put("loginModel1", loginModel);
		return modelAndView;
	}
	
	public  void doGet(){}

}
