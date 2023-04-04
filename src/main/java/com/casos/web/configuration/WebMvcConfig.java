package com.casos.web.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry controllerRegistry) {
		controllerRegistry.addViewController("/").setViewName("index");
        controllerRegistry.setOrder(Ordered.HIGHEST_PRECEDENCE);

	}
	
}
