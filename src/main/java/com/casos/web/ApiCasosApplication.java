package com.casos.web;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.casos.web.service.TelegramBotAPIService;

@SpringBootApplication
public class ApiCasosApplication {
public static final Logger LOG = LoggerFactory.getLogger(ApiCasosApplication.class);

	
	private final TelegramBotAPIService telegramBotAPI;
	
	@Autowired
	public ApiCasosApplication(TelegramBotAPIService telegramBotAPI) {
		this.telegramBotAPI = telegramBotAPI;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiCasosApplication.class, args);
	}
	
	@PostConstruct
	public void init(){
		try {
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
			telegramBotsApi.registerBot(telegramBotAPI);
			LOG.info("Conexion exitosa con BOT de Telegram -> Status 200 | OK");
		}catch (TelegramApiException e) {
			LOG.error("Ocurrio un error al conectarse con el servicio de telegram(BOT)" + e.getMessage());
		}
	}

}
