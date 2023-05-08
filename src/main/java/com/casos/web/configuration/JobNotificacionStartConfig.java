package com.casos.web.configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import com.casos.web.model.Notificacion;
import com.casos.web.service.NotificacionService;

@Configuration
@EnableScheduling
public class JobNotificacionStartConfig implements SchedulingConfigurer{

	@Autowired
	private NotificacionService notificacionService;
	
	private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1); //Ejecuta la tarea en un hilo separado del hilo principal de la Aplicación
	private static final String TIEMPO_JOB = "0 */10 * * * *"; //Cada 10 minutos lanza el JOB
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
	    taskRegistrar.setScheduler(scheduledExecutorService);
	    taskRegistrar.addTriggerTask(() -> {
	        Notificacion notificacion = new Notificacion();
	        notificacion.setTexto("Texto de la notificación");
	        notificacionService.sendNotificacion(notificacion);
	    }, triggerContext -> {
	        CronTrigger cronTrigger = new CronTrigger(TIEMPO_JOB);
	        return cronTrigger.nextExecutionTime(triggerContext);
	    });
	}	
}
