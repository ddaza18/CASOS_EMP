package com.casos.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casos.web.model.Casos;
import com.casos.web.model.ReportesCasos;
import com.casos.web.repository.CasosRepository;

@Service
public class ReportsService {

	@Autowired
	private CasosRepository casosRepository;

	/**
	 * Metodo unicamente para los ADMIN
	 * @return casosList
	 */
	public List<ReportesCasos> obtenerReportesCasos(){
		List<Casos> casos = casosRepository.findAll();
		List<ReportesCasos> casosList = new ArrayList<>();
		for(Casos caso : casos) {
			ReportesCasos reportesCaso = new ReportesCasos();
			reportesCaso.setId(caso.getId_caso());
			reportesCaso.setFechaCreacion(caso.getFecha_creacion());
			reportesCaso.setDescripcion(caso.getDescripcion());
			reportesCaso.setTelefonoCaso(caso.getTelefono());
			reportesCaso.setUsuarioCrea(caso.getUsuario().getName_user() + " " + caso.getUsuario().getApp_user());
			reportesCaso.setCorreoUsuarioCrea(caso.getUsuario().getEmail());
			reportesCaso.setEstado(caso.getEstado_caso());
			casosList.add(reportesCaso);
		}
		
		return casosList;
	}
	
	/**
	 * Metodo para reporte de casos por usuario "logeado"
	 * @param usuario
	 * @return return reporteCasosPorUser;

	
	public List<ReportesCasos> obtenerReportePorUsuario(String usuarioLogeado){
		List<Casos> casosPorUsuario = casosRepository.findByUsuarioEmail(usuarioLogeado);
		List<ReportesCasos> reporteCasosPorUser = new ArrayList<>();
		
		for(Casos caso : casosPorUsuario) {
			ReportesCasos reportesCasos = new ReportesCasos();
			reportesCasos.setId(caso.getId_caso());
			reportesCasos.setFechaCreacion(caso.getFecha_creacion());
			reportesCasos.setDescripcion(caso.getDescripcion());
			reportesCasos.setTelefonoCaso(caso.getTelefono());
			reportesCasos.setEstado(caso.getEstado_caso());
			reporteCasosPorUser.add(reportesCasos);
		}
		
		return reporteCasosPorUser;
	}
	 */

}
