package com.casos.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.casos.web.service.AdminService;

@Controller
public class AdminController {
	public static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

	
	@Autowired
	private AdminService adminService;
	
	/**
	 * Get login admin
	 */
	@GetMapping("/loginAdmin")
	public String loginAdmin() {
		LOG.info("Se entro al login de ADMIN");
		return "loginAdmin";
	}
	
	/**
	 * Get landing page admin
	 */
	@GetMapping("/HomeAdmin")
	public String homeAdmin() {
		LOG.info("Se entro a la landing page de administrativos EMP");
		return "HomeCasoAdmin";
	}
	
	@PostMapping("/loginAdmin/login")
	public String adminLoginValidate(@RequestParam("admin_us") String adminUs, @RequestParam("token") String token, HttpServletRequest req, Model model) {
		if(adminService.validateTokenAndUserAdmin(adminUs, token)) {
			req.getSession().setAttribute("ModoAdmin", true);
			model.addAttribute("success","Modo Administrador activado");
			return "redirect:/HomeCasoAdmin";
		}else {
			model.addAttribute("error","Credenciales Invalidas");
			return "loginAdmin";
		}
	}
	
	
}
