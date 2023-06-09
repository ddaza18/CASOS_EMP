package com.casos.web.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casos.web.model.Casos;

@Repository
public interface CasosRepository extends JpaRepository<Casos, Long> {
	
	Casos save(Casos casos);
	
	@Override
	@EntityGraph(attributePaths = {"usuario"})
    List<Casos> findAll();
	
	List<Casos> findByUsuarioEmail(String email);
	
    List<Casos> findByDescripcionContainingIgnoreCase(String filtro);
        
   @Transactional
   public void deleteById(Long id_caso);
   
   @Transactional
	default void update(Casos casos) {
		save(casos);
	}

}
