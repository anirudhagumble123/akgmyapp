package com.mphasis.akg.auth.web;


import com.mphasis.akg.auth.model.Document;
import com.mphasis.akg.auth.model.User;
import com.mphasis.akg.auth.service.DocumentService;
import com.mphasis.akg.auth.service.SecurityService;
import com.mphasis.akg.auth.service.UserService;
import com.mphasis.akg.auth.validator.DocumentValidator;
import com.mphasis.akg.auth.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	
	
	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private DocumentValidator documentValidator;
	
	@Autowired
	private DocumentService documentService;
	
	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.save(userForm);

		securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/welcome";
	}

	
	  
	/*
	 * @RequestMapping(value = { "/", "/login" }) public String staticResource
	 * (Model model) { return "login"; }
	 */
	  
	  @RequestMapping(value = { "/", "/login" }) public String login(Model model,
	  String error, String logout) { if (error != null) model.addAttribute("error",
	  "Your username and password is invalid.");
	  
	  if (logout != null) model.addAttribute("message",
	  "You have been logged out successfully.");
	  
	  return "login"; }
	 
	

	@GetMapping({ "/", "/welcome" })
	public String welcome(Model model) {
		return "welcome";
	}

	@GetMapping("/index")
	public String index(Model model) {
		return "index";
	}

	
	/*
	 * @GetMapping({"/", "/document"})
	 */
	
	  @GetMapping("/document")
	  public String document(Model model) 
	  {
		  model.addAttribute("documentForm", new Document());

	  return "document"; 
	  }

	  
		@PostMapping("/document")
		public String document(@ModelAttribute("documentForm") Document documentForm, BindingResult bindingResult) 
		{
			documentValidator.validate(documentForm, bindingResult);

			if (bindingResult.hasErrors())
			{
				return "document";
			}
			
			documentService.save(documentForm);

			return "redirect:/welcome";
		}
		
		
		
		
}