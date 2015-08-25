package org.mohammad.ticket.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.mohammad.ticket.model.RegisterModel;
import org.mohammad.ticket.service.RegistrationValidator;
import org.mohammad.ticket.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private RegistrationValidator registrationValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(registrationValidator);
	}
	
	@RequestMapping("/")
	public String home(Principal principal)
	{
		logger.info("in home, principal is null? {}", (principal==null));
		if(principal == null)
			return "forward:/login";
		return "index";
	}
	
	@RequestMapping(value="/login")
	public String login(Model model)
	{
		logger.info("in login, register success: {}", model.containsAttribute("regisrationSuccess"));
		//model.addAttribute("regisrationSuccess", true);
		
		return "login";
	}
	
	@RequestMapping("/register")
	public String registerView(HttpServletRequest req, Model model)
	{
		logger.info("registerView");
		model.addAttribute("registerModel", new RegisterModel());
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegister(Model model, @Valid @ModelAttribute RegisterModel registerModel, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
            return "register";
        }
		logger.info("processRegister, username: {}, email: {}", registerModel.getUsername(), registerModel.getEmail());
		userService.registerUser(registerModel);
		model.addAttribute("regisrationSuccess", true);
		return "login";
		//return "redirect:/login?regisrationSuccess";
	}
}
