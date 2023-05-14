package com.casos.web.configuration;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import com.casos.web.model.Notificacion;
import com.casos.web.repository.AdminNotificacionRepository;
import com.casos.web.service.NotificacionService;

@Configuration
@EnableScheduling
public class JobNotificacionUsuarios implements SchedulingConfigurer{
private static final Logger LOG = LoggerFactory.getLogger(JobNotificacionUsuarios.class);


	@Autowired
	private NotificacionService notificacionService;
	
	@Autowired
	private AdminNotificacionRepository adminNotificacionRepository;
	
	private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1); //Ejecuta la tarea en un hilo separado del hilo principal de la Aplicación
	private static final String TIEMPO_JOB_USU = "0 */5 * * * *";
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		 taskRegistrar.setScheduler(scheduledExecutorService);
		    taskRegistrar.addTriggerTask(() -> {
		        Notificacion notificacion = new Notificacion();
		        notificacion.setTexto("Deslogeando a usuarios inactivos...");
		        notificacion.setFecha(new Date());
		        adminNotificacionRepository.save(notificacion); //Guarda la notificacion independientemente tenga errores en el envio
		        LOG.info("Guardando la notificacion en BD...");
		        notificacionService.sendNotificacion(notificacion);
		    }, triggerContext -> {
		        CronTrigger cronTrigger = new CronTrigger(TIEMPO_JOB_USU);
		        return cronTrigger.nextExecutionTime(triggerContext);
		    });
		
	}

}
