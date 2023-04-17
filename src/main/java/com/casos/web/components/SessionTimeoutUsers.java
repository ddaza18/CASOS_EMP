package com.casos.web.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.casos.web.controllers.PagesAndModulesAllController;

@Component
public class SessionTimeoutUsers implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handle) throws Exception{
		Logger LOG = LoggerFactory.getLogger(SessionTimeoutUsers.class);
		HttpSession session = req.getSession(false);
		// valida el tipo de expiracion comparando la sesion actual - La sesion se invalida y lo redireciona al login
		if(session != null && session.getLastAccessedTime() + (session.getMaxInactiveInterval() * 1000) < System.currentTimeMillis()) {
			LOG.error("Sesion invalidada por inactividad SessionTimeoutUsers");
			session.invalidate();
			res.sendRedirect("/loginUsuarios");
			return false;
		}else {
			return true;
		}
	}
}
