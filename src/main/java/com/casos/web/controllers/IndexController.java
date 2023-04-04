package com.casos.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	public static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	
	@RequestMapping("/home")
	public String getIndex() {
		logger.info("Se ingreso al Home principal");
		return "index";
	}
}
