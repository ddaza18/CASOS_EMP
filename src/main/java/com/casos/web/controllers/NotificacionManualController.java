package com.casos.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casos.web.components.NotificacionJob;

@RestController
@RequestMapping("/notificacion")
public class NotificacionManualController {
	private static final Logger LOG = LoggerFactory.getLogger(NotificacionHandlerController.class);

	private final NotificacionJob notificacionJob;
	
	public NotificacionManualController(NotificacionJob notificacionJob) {
		this.notificacionJob = notificacionJob;
	}
	/**
	 * Rest de envio de notificacion Manual
	 * @return
	 */
	
	@PostMapping("/sendNot")
	public ResponseEntity<String> enviarNotificacion(){
		notificacionJob.sendNotificacion();
		LOG.info("==================================");
		LOG.info("Notificacion Manual Enviada -> OK");
		LOG.info("==================================");
		return ResponseEntity.ok("Notificacion Manual Enviada.");
	}
	
	
	
}
