package com.casos.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class NotificacionHandlerController {
	private static final Logger LOG = LoggerFactory.getLogger(NotificacionHandlerController.class);
	
	private SimpMessagingTemplate simpMessagingTemplate;
	
	public NotificacionHandlerController(SimpMessagingTemplate simpMessagingTemplate) {
		this.simpMessagingTemplate = simpMessagingTemplate;
	}
	
	@MessageMapping("/notificacion")
	@SendTo("/topic/notificacion")
	public String handleNotificacion(String mensaje) {
		LOG.info("Mensaje recibido: {}", mensaje);
		return mensaje;
	}
}
