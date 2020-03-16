package com.mphasis.akg.auth.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import com.mphasis.akg.auth.model.Document;
import com.mphasis.akg.auth.model.User;
import com.mphasis.akg.auth.service.DocumentService;
import com.mphasis.akg.auth.service.SecurityService;
import com.mphasis.akg.auth.service.UserService;
import com.mphasis.akg.auth.validator.DocumentValidator;
import com.mphasis.akg.auth.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
	  "Your userdocumentname and password is invalid.");
	  
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
		  model.addAttribute("documentForm", new Document(null, null, null));

	  return "document"; 
	  }

	  
	
	  
		@PostMapping("/document")
		public String document(@ModelAttribute("documentForm") Document documentForm, BindingResult bindingResult,MultipartFile data) throws IOException 
		{
			documentValidator.validate(documentForm, bindingResult);

			if (bindingResult.hasErrors())
			{
				return "document";
			}

			System.out.println("NOT GOING TO STOREFILE METHOD");
		
		  
			documentService.storeFile(data);
		 
			
			documentService.save(documentForm);
			System.out.println("file upload happening");
			
			return "redirect:/welcome";
		}
		
	
}	