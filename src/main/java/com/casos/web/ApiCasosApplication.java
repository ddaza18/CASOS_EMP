package com.casos.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.casos.web.components.TelegramBotAPI;

@SpringBootApplication
public class ApiCasosApplication {
public static final Logger LOG = LoggerFactory.getLogger(ApiCasosApplication.class);

	
	private final TelegramBotAPI telegramBotAPI;
	
	@Autowired
	public ApiCasosApplication(TelegramBotAPI telegramBotAPI) {
		this.telegramBotAPI = telegramBotAPI;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiCasosApplication.class, args);
		
		//Se tiene que registar el BOT para su funcionamiento
		try {
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
			telegramBotsApi.registerBot(new TelegramBotAPI());
			LOG.info("Conectando con el BOT de Telegram -> STATUS 200|OK");
		}catch(TelegramApiException e) {
			LOG.error("Fallo en Registro del BOT a la aplicacion.", e.getMessage());
		}
	}

}
