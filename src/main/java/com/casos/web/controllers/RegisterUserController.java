package com.casos.web.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.casos.web.dto.UsersRegisterDTO;
import com.casos.web.service.UsersService;

@Controller
@RequestMapping("/registroUsuarios")
public class RegisterUserController {
	public static final Logger logger = LoggerFactory.getLogger(RegisterUserController.class);
	
	private UsersService usersService;
	

	public RegisterUserController(UsersService usersService) {
		super();
		this.usersService = usersService;
	}
	
	@ModelAttribute("user")
	public UsersRegisterDTO returnNewUserRegisterDTO() {
		return new UsersRegisterDTO();
	}
	
	@GetMapping()
	public String ShowRegister() {
		logger.info("Se ingreso al registro");
		return "registro";
	}
	
	@PostMapping
	public String regiterCountUser(@ModelAttribute("user") UsersRegisterDTO registroDTO) {
		usersService.save(registroDTO);
		return "redirect:/registroUsuarios?exito";
	}
	
}
