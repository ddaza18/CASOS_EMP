package com.casos.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.casos.web.components.SessionTimeoutUsers;

public class ConfigInactiveSessionUsersApp extends WebMvcConfigurerAdapter {
	
	@Autowired
	private SessionTimeoutUsers sessionTimeoutUsers;
	
	/**
	 * Se asegura de ejecutar el componente cada que reciba una solicitud
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionTimeoutUsers); 
	}
	
}
