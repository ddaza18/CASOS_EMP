package com.casos.web.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.casos.web.model.Casos;
import com.casos.web.repository.CasosRepository;
import com.casos.web.service.AdminService;
import com.casos.web.service.CasosService;

@Controller
public class AdminController {
	public static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CasosRepository casosRepository;
	
	@Autowired
	private CasosService casosService;
	
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
	
	/**
	 * 	GET de landing Page Y POST para "solucion de casos" -> Cambia a estado "SOLUCIONADO"
	 */
	@GetMapping("/SolucionesCaso/{id_caso}")
	public String pageSolucionCaso(Model model, @PathVariable("id_caso") Long id_caso) {
		Optional<Casos> casosOpt = casosRepository.findById(id_caso);
		if(casosOpt.isPresent()) {
			LOG.info("Caso encontrado en BD");
			model.addAttribute("casos", casosOpt.get());
			return "SolucionCasos";
		}else {
			LOG.error("No se encontraron casos relacionados 404 Not Found");
			return "redirect:/Error404";
		}
	}
	
	@PostMapping("/ModificarEstadoCaso/{id_caso}")
	public String solucionCaso(@PathVariable("id_caso") Long id_caso, @ModelAttribute("casos") Casos casosReq, RedirectAttributes redirectAttributes ) {
		Casos casos = casosService.buscarPorId(id_caso).orElse(null);
		
		if(casos == null) {
			LOG.error("Caso a modificar no se encuentra en la BD.");
			return "redirect:/Error404";
		}
		casos.setEstado_caso(casosReq.getEstado_caso());
		LOG.info("Se modifico el caso con exito.");
		casosService.actualizarCasos(casos);
		redirectAttributes.addAttribute("id_caso", casos.getId_caso());
		return "redirect:/HomeCasoAdmin";
	}
	
	/**
	 * Eliminar caso desde ADMIN	
	 */
	@GetMapping("/CasosAdmin/{id_caso}")
	public String eliminarCaso(@PathVariable("id_caso") Long id_caso) {
		Optional<Casos> casos = casosRepository.findById(id_caso);
		if(!casos.isPresent()) {
			LOG.error("Caso no encontrado en la BD.");
			return "redirect:/Error404";
		}
		casosRepository.deleteById(id_caso);
		return "redirect:/HomeCasoAdmin";
	}
	/**
	 * Landing page de Twilio envios de SMS
	 */
	@GetMapping("/TwilioSMS")
	public String pageTwilioSMS() {
		LOG.info("Se ingreso al apartado de Twilio envios de SMS...");
		return "Twilio";
	}
	
}
