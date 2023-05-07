package com.casos.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.casos.web.service.SmsServiceTwilio;

@RestController
public class AdminSendSmsController {

	@Autowired
	private SmsServiceTwilio smsServiceTwilio;
	
	/*
	 * Funcionalidad para el envio de los SMS
	 */
	
}
