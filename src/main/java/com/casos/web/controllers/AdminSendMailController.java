package com.casos.web.controllers;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.casos.web.service.AdminSenderMailService;

@RestController
public class AdminSendMailController {
	public static final Logger LOG = LoggerFactory.getLogger(AdminSendMailController.class);

	@Autowired
	private AdminSenderMailService adminServiceSenderMail;

	/**
	 * Get envio de Correo a GMAIL
	 */
	@GetMapping("/sendMail")
	public ModelAndView sendMail(@RequestParam("para") String para, @RequestParam("subject") String subject,
			@RequestParam("cont") String cont, Model model) throws MessagingException {
		ModelAndView modelAndView = new ModelAndView("redirect:/HomeCasoAdmin");
		boolean isSent = adminServiceSenderMail.sendMail(para, subject, cont);

		if (isSent) {
			model.addAttribute("message", "Correo enviado correctamente.");
		} else {
			model.addAttribute("message", "No se pudo enviar el correo.");
		}

		return modelAndView;
	}

}
