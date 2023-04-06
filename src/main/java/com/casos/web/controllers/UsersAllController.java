package com.casos.web.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.management.Query;
import javax.swing.JWindow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.casos.web.model.Casos;
import com.casos.web.model.Usuario;
import com.casos.web.repository.CasosRepository;
import com.casos.web.repository.UsuarioRepositorio;
import com.casos.web.service.CasosService;

@Controller
@RequestMapping("/")
public class UsersAllController {
	public static final Logger logger = LoggerFactory.getLogger(UsersAllController.class);

	@Autowired
	private CasosRepository casosRepository;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private CasosService casosService;

	
	@GetMapping("/Error404")
	public String paginaNoEncontrada() {
		logger.error("Error 404 Pagina No Encontrada");
		return "NotFound";
	}
	
	@GetMapping("/loginUsuarios")
	public String peticionIndex() {
		logger.info("Se entro al login");
		return "index_login";
	}

	@GetMapping("/HomeCasoUser")
	public String peticionHomeAccesoUserCrearcaso(Model model, Authentication authentication) {
		logger.info("Se entro al home de CrearCasoUser");
		Usuario usuario = usuarioRepositorio.findByEmail(authentication.getName());
		List<Casos> casos = casosRepository.findByUsuarioEmail(usuario.getEmail());
		 model.addAttribute("casos", casos);
		return "HomeCasoUser";
	}
	
	@GetMapping("/CrearCasos")
	public String crearCasos(Model model) {
		model.addAttribute("casos", new Casos());
		logger.info("Se ingreso al apartado de CrearCasos");
		return "CrearCasos";
	}
	
	@PostMapping("/CrearCasos")
	public String casosCreadosPost(@ModelAttribute("casos") Casos casos, Model model, Authentication authentication) {
		LocalDateTime localDateTime = LocalDateTime.now();
		Date fechaCreacion = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		casos.setFecha_creacion(fechaCreacion);
		casos.setEstado_caso("PENDIENTE");
		String currentUserId = authentication.getName();
		Usuario user = usuarioRepositorio.findByEmail(currentUserId);
		casos.setUsuario(user);
		casosRepository.save(casos);
		logger.info("El caso se registro en la BD con exito!");
		return "redirect:/HomeCasoUser";
	}
	
	/*
	 * Get del ModificarCasos HTML
	 */
	
	@GetMapping("/ModificarCasos/{id_caso}")
	public String actualizarCasos(Model model, @PathVariable("id_caso") Long id_caso) {
	    Optional<Casos> casosOpt = casosRepository.findById(id_caso);
	    if(casosOpt.isPresent()) {
	        logger.error("Caso Encontrado en BD.");
	        model.addAttribute("casos", casosOpt.get());
	        return "EditarCaso";
	    } else {
	    	logger.error("No se encontraron casos Relacionados 404 Not Found");
	        return "redirect:/Error404";
	    }
	}
	
	/*
	 * Guarda el caso Actualizado POST
	 */
	
	@PostMapping("/ActualizarCasos/{id_caso}")
	public String guardarModificacionesCasos(@PathVariable("id_caso") Long id_caso, @ModelAttribute("casos") Casos casosReq, RedirectAttributes redirectAttributes) {
		Casos casos = casosService.buscarPorId(id_caso).orElse(null);
		
		if(casos == null) {
			logger.error("El caso a modificar no existe en la BD.");
			return "redirect:/Error404";
		}
		casos.setDescripcion(casosReq.getDescripcion());
		casos.setTelefono(casosReq.getTelefono());
		logger.info("Se Modifico el Caso con Exito!");
		casosService.actualizarCasos(casos);
		redirectAttributes.addAttribute("id_caso", casos.getId_caso());
		return "redirect:/HomeCasoUser";

	}
	
	/*
	 * Metodo de eliminar Casos
	 */
	
	@GetMapping("/Casos/{id_caso}")
	public String eliminarCasos(@PathVariable Long id_caso){
		Optional<Casos> casos = casosRepository.findById(id_caso);
		if(!casos.isPresent()) {
			logger.error("Caso no encontrado en la BD.");
			return "redirect:/Error404"; //Crear pagina Not Found 404
		}
		casosRepository.deleteById(id_caso);
		return "redirect:/HomeCasoUser";
		
	}
	
	/*
	 * Filtro de Casos
	 */
	@GetMapping("/filtrar")
	public String filtrarCasos(@RequestParam("filtro") String filtro, Model model){
		List<Casos> casos = casosRepository.findByDescripcionContainingIgnoreCase(filtro);
		model.addAttribute("casos",casos);
		logger.info("Se Encuentran Filtrando Casos");
		return "HomeCasoUser";
	}
	
}
