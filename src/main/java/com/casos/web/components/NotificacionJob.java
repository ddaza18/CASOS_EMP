package com.casos.web.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificacionJob {
	public static final Logger LOG = LoggerFactory.getLogger(NotificacionJob.class);

	private final SimpMessagingTemplate messagingTemplate;
	
	public NotificacionJob(SimpMessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}
	
	/**
	 * Este se ejecutara cada 10 minutos, osea cada (600.000 ms)
	 */
	@Scheduled(fixedDelay = 600000)
	public void sendNotificacion() {
		LOG.info("Inciando Ejecucion JOB -> Notificacion Programada...");
		String msj = "Este mensaje programado se envia cada 10 minutos 'sendNotificacion()'";
		messagingTemplate.convertAndSend("/topic/notification", msj);
	}

}
