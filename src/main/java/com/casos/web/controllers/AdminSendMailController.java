package com.casos.web.controllers;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casos.web.service.AdminSenderMail;

@RestController
public class AdminSendMailController {
	public static final Logger LOG = LoggerFactory.getLogger(AdminSendMailController.class);

	@Autowired
	private AdminSenderMail adminServiceSenderMail;

	/**
	 * Get envio de Correo a GMAIL
	 */
	@GetMapping("/sendMailPrueba")
	public String sendMail(Model model) throws MessagingException {
		String to = "ddaza681@gmail.com	";
		String subject = "(IMPORTANTE) - Correo de Prueba desde Aplicacion JAVA";
		String cont = "Prueba desde casos EMP";
		boolean isSent = adminServiceSenderMail.sendMail(to,subject, cont);
		
		if(isSent){
			model.addAttribute("message","Correo enviado correctamente.");
		}else {
			model.addAttribute("message","No se pudo enviar el correo.");
		}
		
		return "";
	}

}
