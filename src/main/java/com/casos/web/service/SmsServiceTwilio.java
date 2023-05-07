package com.casos.web.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsServiceTwilio {

	@Value("${twilio.phone.number}")
	private String fromNumberPhone;
	
	public void enviarSMS(String paraSmsNumberPhone, String msj) throws TwilioException{
		Message sms = Message.creator(
				new PhoneNumber(fromNumberPhone),
				new PhoneNumber(paraSmsNumberPhone), 
				msj).create();
	}
	
}
