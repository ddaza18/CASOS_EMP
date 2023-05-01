package com.casos.web.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.casos.web.model.Correo;
import com.casos.web.repository.AdminCorreoRepository;

@Service
public class AdminSenderMail {
	public static final Logger LOG = LoggerFactory.getLogger(AdminSenderMail.class);

	@Autowired
	private AdminCorreoRepository adminCorreoRepository;

	public boolean sendMail(String para, String subject, String cont) {

		try {
			Properties properties = new Properties();

			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.office365.com");
			properties.put("mail.smtp.port", "587");

			Session session = Session.getInstance(properties, new Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("casosemp@outlook.com", "Sacha123*");
				}

			});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("casosemp@outlook.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(para));
			message.setSubject(subject);
			message.setContent(cont, "text/html; charset=utf-8");

			Transport.send(message);

			Correo correo = new Correo();
			correo.setPara(para);
			correo.setSubject(subject);
			correo.setCont(cont);
			correo.setFechaDeEnvio(new Date());
			adminCorreoRepository.save(correo);

			LOG.info("Correo enviado con exito y guardado en BD.");
			return true;

		} catch (MessagingException e) {
			LOG.error("Fallo el envio del correo SendMail",e.getMessage());
			return false;
		}
	}

}
