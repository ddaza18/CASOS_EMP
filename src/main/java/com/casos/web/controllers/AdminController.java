package com.casos.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.casos.web.model.Casos;
import com.casos.web.repository.CasosRepository;
import com.casos.web.service.AdminService;

@Controller
public class AdminController {
	public static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
	
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CasosRepository casosRepository;
	
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
	@GetMapping("/HomeCasoAdmin")
	public String homeAdmin(Model model) {
		LOG.info("Se entro a la landing page de administrativos EMP");
		List<Casos> casos = casosRepository.findAll();
		model.addAttribute("casos",casos);		
		return "HomeCasoAdmin";
	}
	
	@PostMapping("/loginAdmin/login")
	public String adminLoginValidate(@RequestParam("admin") String admin, @RequestParam("token") String token, HttpServletRequest req) {
		if(adminService.validateTokenAndUserAdmin(admin, token)) {
			req.getSession().setAttribute("ModoAdmin", true);
			return "redirect:/HomeCasoAdmin";
		}else {
			return "loginAdmin";
		}
	}
	
	@GetMapping("/loginAdmin/login")
	public String logOutAdminMode(HttpServletRequest req) {
		req.getSession().setAttribute("ModoAdmin", false);
		LOG.info("Volviendo al modo USER...");
		return "redirect:/loginAdmin";
	}
	
	/**
	 * Get landing page envio de correos CASOS EMP
	 */
	@GetMapping("/CorreoCasosEMP")
	public String pageChat() {
		LOG.info("Se ingreso al envio de correos de casos EMP...");
		return "CorreoEMP";
	}
	
	
}
