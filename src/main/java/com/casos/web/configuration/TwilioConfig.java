package com.casos.web.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.twilio.http.TwilioRestClient;

@Configuration
public class TwilioConfig {

	@Value("${twilio.account.sid}")
	private String accountSid;
	
	@Value("${twilio.auth.token}")
	private String tokenAuth;
	
	/**
	 * Configura la conexion con los Token
	 * @return los tokens generados y los construye
	 */
	
	@Bean
	public TwilioRestClient twilioRestClient() {
		return new TwilioRestClient.Builder(tokenAuth, accountSid).build();
	}
	
}
