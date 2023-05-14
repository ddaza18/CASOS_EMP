package com.casos.web.service;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casos.web.model.Notificacion;
import com.casos.web.repository.AdminNotificacionRepository;

@Service
public class NotificacionService {
	public static final Logger LOG = LoggerFactory.getLogger(NotificacionService.class);


	private final AdminNotificacionRepository adminNotificacionRepository;
	private final ScheduledExecutorService scheduledExecutorService;
	
	@Autowired
	public NotificacionService(AdminNotificacionRepository adminNotificacionRepository) {
		this.adminNotificacionRepository = adminNotificacionRepository;
		this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
	}
	
	public void programrNotificaciones() {
		List<Notificacion> notificaciones = adminNotificacionRepository.findAll();
		
		/**
		 * Programar la tarea para cada notificacion
		 */
		for(Notificacion notificacion : notificaciones) {
			scheduledExecutorService.scheduleAtFixedRate(() -> sendNotificacion(notificacion),
					0, //delay inicial
					10, //intervalo de 10mins en cada notificacion 
					TimeUnit.MINUTES);
		}
	}
	
	/**
	 * Logica para enviar la notificacion
	 */

	public void sendNotificacion(Notificacion notificacion) {
		LOG.info("Notificacion: " + notificacion.getTexto());
	}
	
	public void stopNotificaciones() {
		scheduledExecutorService.shutdown();
	}
}
