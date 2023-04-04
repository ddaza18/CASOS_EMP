package com.casos.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casos.web.model.Casos;
import com.casos.web.repository.CasosRepository;

@Service
public class CasosService {
	
	@Autowired
	private CasosRepository casosRepository;
	
	public void actualizarCasos(Casos casos) {
		casosRepository.update(casos);
	}
	public Optional<Casos> buscarPorId(Long id_caso){
		return casosRepository.findById(id_caso);
	}
}
